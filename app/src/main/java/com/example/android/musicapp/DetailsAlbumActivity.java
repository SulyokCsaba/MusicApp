package com.example.android.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsAlbumActivity extends AppCompatActivity {

    @BindView(R.id.det_name) TextView bkName_TV;
    @BindView(R.id.det_Descriotion) TextView bkDesc_TV;
    @BindView(R.id.det_image) ImageView bkImage_IV;
    @BindView(R.id.det_year) TextView bkYear_TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_album);

        //Binding of ButterKnife
        ButterKnife.bind(this);

        //Get the properties of the Album Object from the intent
        Bundle b = getIntent().getExtras();
        final String albumName = b.getString(getString(R.string.UIName));
        final String albumDesc = b.getString(getString(R.string.UIDesc));
        final String albumYear = b.getString(getString(R.string.UIYear));
        int albumPhoto = b.getInt(getString(R.string.UIPhoto));

        this.setTitle(albumName);

        //ButterKnife of the TextView for Name
        bkName_TV.setText(albumName);
        //ButterKnife of the TextView for Address
        bkDesc_TV.setText(albumDesc);
        //ButterKnife of the TextView for Phone
        bkYear_TV.setText(albumYear);
        //ButterKnife of the Imageview for Photo
        bkImage_IV.setImageResource(albumPhoto);


    }
}
