package br.com.resource.mymarvelcharacters;

import br.com.resource.mymarvelcharacters.models.MarvelRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public interface MarvelClient {
    String API_KEY = "apikey";
    String HASH = "hash";
    String TIMESTAMP = "ts";
    String LIMIT = "limit";
    String OFFSET = "offset";

    @GET("v1/public/characters")
    Call<MarvelRepo> listRepositories(
            @Query(API_KEY) String publicKey,
            @Query(HASH) String hash,
            @Query(TIMESTAMP) long timestamp,
            @Query(LIMIT) int limit,
            @Query(OFFSET) int offset);
}
