package br.com.resource.mymarvelcharacters.activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import br.com.resource.mymarvelcharacters.R;
import br.com.resource.mymarvelcharacters.models.Results;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        Results results = (Results) bundle.getSerializable("results");

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(results.getName());

        TextView txt_description = findViewById(R.id.txt_description);
        ImageView img_details = findViewById(R.id.img_details);

        txt_description.setText(results.getDescription());

        String path = results.getThumbnail().getPath();
        String extension = results.getThumbnail().getExtension();

        if(getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(getApplication()).load(path + "/portrait_uncanny." + extension).into(img_details);
        } else {
            Picasso.with(getApplication()).load(path + "/landscape_incredible." + extension).into(img_details);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
