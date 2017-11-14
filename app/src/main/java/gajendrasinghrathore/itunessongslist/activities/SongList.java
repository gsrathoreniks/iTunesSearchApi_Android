package gajendrasinghrathore.itunessongslist.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import gajendrasinghrathore.itunessongslist.Adapter.CustomListAdapter;
import gajendrasinghrathore.itunessongslist.R;
import gajendrasinghrathore.itunessongslist.pojos.Songs;
import gajendrasinghrathore.itunessongslist.utilities.Constants;

public class SongList extends AppCompatActivity {

    ArrayList<Songs> arrayList;
    ListView lv;
    JSONObject songObject;
    private JSONArray jsonArray;
    JSONObject jsonObject;
    private String wrapperType;
    private String kind;
    private String artistId;
    private String artistName;
    private String collectionName;
    private String trackCensoredName;
    private String releaseDate;
    private String country;
    private String currency;
    private String trackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               getDataForThisPosition(position);

            }
        });


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute(Constants.baseURL);
            }
        });
    }

    private void getDataForThisPosition(Integer position) {
        try {
            jsonArray =  jsonObject.getJSONArray("results");

            songObject = jsonArray.getJSONObject(position);
            kind =  songObject.getString("kind");
            wrapperType =  songObject.getString("wrapperType");
            trackName = songObject.getString("trackName");
            artistId = songObject.getString("artistId");
            artistName = songObject.getString("artistName");
            collectionName = songObject.getString("collectionName");
            trackCensoredName = songObject.getString("trackCensoredName");
            releaseDate = songObject.getString("releaseDate");
            country = songObject.getString("country");
            currency = songObject.getString("currency");
            Intent intent = new Intent(SongList.this,SongDetails.class);
            intent.putExtra("kind",kind);
            intent.putExtra("wrapperType",wrapperType);
            intent.putExtra("trackName",trackName);
            intent.putExtra("artistId",artistId);
            intent.putExtra("artistName",artistName);
            intent.putExtra("collectionName",collectionName);
            intent.putExtra("trackCensoredName",trackCensoredName);
            intent.putExtra("releaseDate",releaseDate);
            intent.putExtra("country",country);
            intent.putExtra("currency",currency);
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                jsonObject = new JSONObject(content);
                jsonArray =  jsonObject.getJSONArray("results");

                for(int i =0;i<jsonArray.length(); i++){
                    songObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Songs(
                            songObject.getString("artworkUrl100"),
                            songObject.getString("trackName"),
                            songObject.getString("artistName"),
                            songObject.getString("collectionName")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomListAdapter adapter = new CustomListAdapter(
                    getApplicationContext(), R.layout.custom_list_layout, arrayList
            );
            lv.setAdapter(adapter);
        }
    }


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
