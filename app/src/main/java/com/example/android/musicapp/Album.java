package com.example.android.musicapp;

public class Album {

    //Name of the place
    private String mName;
    private String mDescrip;
    private String mYear;
    //Info of the Cover of the Album
    private int mIDImage;


    public Album(String idName, String description, String year, int cover) {

        mName= idName;
        mDescrip = description;
        mYear = year;
        mIDImage = cover;

    }

    public String getName() {return mName;}

    public String getDescription() {return mDescrip;}

    public String getYear() {return mYear;}

    public int getIDImage() {return mIDImage;}

}