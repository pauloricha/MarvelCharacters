package br.com.resource.mymarvelcharacters.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.resource.mymarvelcharacters.MarvelApi;
import br.com.resource.mymarvelcharacters.R;
import br.com.resource.mymarvelcharacters.adapters.AdapterCharacters;
import br.com.resource.mymarvelcharacters.models.Results;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class HomeActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<Results> results = new ArrayList<Results>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_characters);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);
        getSupportActionBar().setElevation(0);

        gv = findViewById(R.id.gv_characters);

        Bundle bundle = getIntent().getExtras();
        results = (ArrayList<Results>) bundle.getSerializable("results");

        AdapterCharacters adapterCharacters = new AdapterCharacters(getApplicationContext(), results);
        gv.setAdapter(adapterCharacters);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(results.get(position).getDescription().equals("")){
                    Toast.makeText(getApplicationContext(), "Esse personagem não contém descrição no momento", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("results", results.get(position));
                    intent.putExtras(bundle);
                    getApplication().startActivity(intent);
                }
            }
        });

        gv.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScroll(AbsListView view,
                                 int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                //Algorithm to check if the last item is visible or not
                final int lastItem = firstVisibleItem + visibleItemCount;
                if(lastItem == totalItemCount){
                    //new MarvelApi(HomeActivity.this, 0, results);
                }
            }
            @Override
            public void onScrollStateChanged(AbsListView view,int scrollState) {
                //blank, not required in your case
            }
        });
    }
}
