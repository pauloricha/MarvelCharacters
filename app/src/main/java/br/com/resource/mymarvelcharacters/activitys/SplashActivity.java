package br.com.resource.mymarvelcharacters.activitys;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.resource.mymarvelcharacters.MarvelApi;
import br.com.resource.mymarvelcharacters.R;
import br.com.resource.mymarvelcharacters.models.Results;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class SplashActivity extends Activity {

    private ArrayList<Results> getResults = new ArrayList<Results>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new MarvelApi(SplashActivity.this, 0, getResults);
    }
}