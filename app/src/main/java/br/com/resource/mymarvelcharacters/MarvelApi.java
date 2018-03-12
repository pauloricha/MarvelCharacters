package br.com.resource.mymarvelcharacters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import br.com.resource.mymarvelcharacters.activitys.HomeActivity;
import br.com.resource.mymarvelcharacters.models.MarvelRepo;
import br.com.resource.mymarvelcharacters.models.Results;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class MarvelApi  {

    private Context context;
    private ArrayList<Results> getResults = new ArrayList<Results>();
    private ArrayList<Results> resultsFilter = new ArrayList<Results>();
    private int offset = 0;

    public MarvelApi(Context context, int offset, ArrayList<Results> getResults){
        this.context = context;
        this.offset = offset;
        this.getResults = getResults;
        callApi();
    }

    private void callApi(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        String API_BASE_URL = "http://gateway.marvel.com/";
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        MarvelClient client =  retrofit.create(MarvelClient.class);

        String publicKey = "55741f760e715589fea2370c3e1a2e4a";
        String privateKey = "33c8965b7b242ebec1b448712c2cb5b34919203d";
        long ts = System.currentTimeMillis() / 1000;
        String hash = getMd5(ts + privateKey + publicKey);

        int limit = 100;

        Call<MarvelRepo> call = client.listRepositories(publicKey, hash, ts, limit, offset);

        call.enqueue(new Callback<MarvelRepo>() {
            @Override
            public void onResponse(Call<MarvelRepo> call, Response<MarvelRepo> response) {

                if(response.isSuccessful()){
                    Log.i("LOOG", "Successful");
                    Collections.addAll(getResults, response.body().data.getResults());

                    /*for(Results result : getResults) {
                        if (!result.getDescription().equals("")) {
                            resultsFilter.add(result);
                        }
                    }*/

                    Intent intent = new Intent(context, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("results", getResults);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                } else {
                    Log.i("LOOG", "Unsuccessful -> " + response.message());
                    response.message();
                }
            }

            @Override
            public void onFailure(Call<MarvelRepo> call, Throwable t) {
                Log.i("LOOG", "onFailure -> " + t.getMessage());
            }
        });
    }

    public String getMd5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
