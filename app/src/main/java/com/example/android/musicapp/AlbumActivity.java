package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);


        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album(getString(R.string.Alb_DaftPunk1_Name), getString(R.string.Alb_DaftPunk1_Desc), getString(R.string.Alb_DaftPunk1_Year), R.drawable.daftpunkalbum2));
        albums.add(new Album(getString(R.string.Alb_DaftPunk2_Name), getString(R.string.Alb_DaftPunk2_Desc), getString(R.string.Alb_DaftPunk2_Year), R.drawable.daftpunkalbum4));
        albums.add(new Album(getString(R.string.Alb_DaftPunk3_Name), getString(R.string.Alb_DaftPunk3_Desc), getString(R.string.Alb_DaftPunk3_Year), R.drawable.daftpunkalbum));
        albums.add(new Album(getString(R.string.Alb_DaftPunk4_Name), getString(R.string.Alb_DaftPunk4_Desc), getString(R.string.Alb_DaftPunk3_Year), R.drawable.daftpunkalbum3));


        // Create an {@link AlbumAdapter}, whose data source is a list of {@link Album}s. The
        // adapter knows how to create list items for each item in the list.

        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SitioAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Sitio} in the list.
        listView.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Linear_Album:
                break;

            default: break;
        }



    }
}