package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * External Libraries
 * ButterKnife at: http://jakewharton.github.io/butterknife/
 */

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Declaring Interface Objects
    @BindView(R.id.Linear_Album) LinearLayout bk_linear_album;
    @BindView(R.id.Linear_Artist) LinearLayout bk_linear_artist;
    @BindView(R.id.Linear_Player) LinearLayout bk_linear_player;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //Instance the Interface Objects

        bk_linear_album.setOnClickListener(this);
        bk_linear_player.setOnClickListener(this);
        bk_linear_artist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Linear_Album:
                //create Intent
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                // Start the new activity
                startActivity(albumIntent);
                break;

            case R.id.Linear_Artist:
                //create Intent
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                // Start the new activity
                startActivity(artistIntent);
                break;

            case R.id.Linear_Player:
                //create Intent
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                // Start the new activity
                startActivity(playerIntent);
                break;

            default: break;
        }



    }
}