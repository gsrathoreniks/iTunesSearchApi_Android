package gajendrasinghrathore.itunessongslist.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import gajendrasinghrathore.itunessongslist.R;

public class SongDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView kind = (TextView)findViewById(R.id.kind);
        TextView wrappertype = (TextView)findViewById(R.id.wrapperType);
        TextView currency = (TextView)findViewById(R.id.currency);
        TextView country = (TextView)findViewById(R.id.country);
        TextView collectionname = (TextView)findViewById(R.id.collectionname);
        TextView artistid = (TextView)findViewById(R.id.artistid);
        TextView artistname = (TextView)findViewById(R.id.artistname);
        TextView trackcensoredname = (TextView)findViewById(R.id.trackcensoredname);
        TextView releasedate = (TextView)findViewById(R.id.releasedate);
        TextView trackname = (TextView)findViewById(R.id.trackname);

        kind.setText("kind  :  "+getIntent().getExtras().getString("kind"));
        wrappertype.setText("wrapperType  :  "+getIntent().getExtras().getString("wrapperType")+"\n");
        artistname.setText("artistName  :  "+getIntent().getExtras().getString("artistName")+"\n");
        artistid.setText("artistId  :  "+getIntent().getExtras().getString("artistId")+"\n");
        collectionname.setText("collectionName  :  "+getIntent().getExtras().getString("collectionName")+"\n");
        trackname.setText("trackName  :  "+getIntent().getExtras().getString("trackName")+"\n");
        releasedate.setText("releaseDate  :  "+getIntent().getExtras().getString("releaseDate")+"\n");
        trackcensoredname.setText("trackCensoredName  :  "+getIntent().getExtras().getString("trackCensoredName")+"\n");
        currency.setText("currency  :  "+getIntent().getExtras().getString("currency")+"\n");
        country.setText("country  :  "+getIntent().getExtras().getString("country")+"\n");
        
    }

}
