package br.com.resource.mymarvelcharacters.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import br.com.resource.mymarvelcharacters.R;
import br.com.resource.mymarvelcharacters.models.Results;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class AdapterCharacters extends BaseAdapter {
    private Context context;
    private ArrayList<Results> results;
    private LayoutInflater inflater;

    public AdapterCharacters(Context applicationContext, ArrayList<Results> results) {
        this.context = applicationContext;
        this.results = results;
        inflater = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return results.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layout_card_view, null);

        TextView txt_character = view.findViewById(R.id.txt_character);
        ImageView img_character = view.findViewById(R.id.img_character);

        Results result = results.get(position);

        if(!result.getDescription().equals("") || !result.getDescription().equals(null)){
            String path = result.getThumbnail().getPath();
            String extension = result.getThumbnail().getExtension();

            txt_character.setText(result.getName());

            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                Picasso.with(context).load(path + "/portrait_uncanny." + extension).into(img_character);
            } else {
                Picasso.with(context).load(path + "/landscape_incredible." + extension).into(img_character);
            }
        } else{
            return view;
        }

        return view;
    }
}
