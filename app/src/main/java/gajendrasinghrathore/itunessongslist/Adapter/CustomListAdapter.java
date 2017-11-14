package gajendrasinghrathore.itunessongslist.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gajendrasinghrathore.itunessongslist.R;
import gajendrasinghrathore.itunessongslist.pojos.Songs;

/**
 * Created by gajendrasinghrathore on 14/11/17.
 */
public class CustomListAdapter extends ArrayAdapter<Songs> {

    ArrayList<Songs> songs;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Songs> songs) {
        super(context, resource, songs);
        this.songs = songs;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);

        }
        Songs songs = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(context).load(songs.getImage()).into(imageView);

        TextView trackName = (TextView) convertView.findViewById(R.id.trackName);
        trackName.setText(songs.getTrackName());

        TextView collectionName = (TextView) convertView.findViewById(R.id.collectionName);
        collectionName.setText(songs.getCollectionName());
        
        TextView artistName = (TextView) convertView.findViewById(R.id.artistName);
        artistName.setText(songs.getArtistName());

        return convertView;
    }
}
