package com.example.android.musicapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * {@link AlbumAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Album} objects.
 * TODO: Icon for Animal Services Like Water avalaible or The place has it's own dog resident
 */


public class AlbumAdapter extends ArrayAdapter<Album> {

    private Context context = getContext();

    /**
     * Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param albums  is the list of {@link Album}s to be displayed.
     */


    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    //Use of the ButterKnife by advice of Reviewer
    @BindView(R.id.name_text_view) TextView nameTextView;
    @BindView(R.id.desc_text_view) TextView descTextView;
    @BindView(R.id.year_text_view) TextView yearTextView;
    @BindView(R.id.photo_image_view) ImageView albumImageView;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
            ButterKnife.bind(this, listItemView);
        }

        //Alternate Colors for the row of the Adapter
        //If I use the method code I got an error of API, I get it is a newer thing.
        //But if not I have to use object Color and directly put an int of the color that usually is less useful
        //For changes, or get some deprecated methods.
        if (position % 2 == 1) {
            listItemView.setBackgroundColor(context.getColor(R.color.colorAltRows));
        } else {
            listItemView.setBackgroundColor(context.getColor(R.color.colorBackground_Splash));
        }

        // Get the {@link Word} object located at this position in the list
        Album currentAlbum = getItem(position);

        //Lets Get the variables we neeed for modify the UI and for the intent of the detailed view
        String iName = currentAlbum.getName();
        String iDescription = currentAlbum.getDescription();
        int iImageID = currentAlbum.getIDImage();
        String iYear = currentAlbum.getYear();


        // Name Set Text
        nameTextView.setText(iName);
        //Adress Set Text
        descTextView.setText(iDescription);
        //Phone Set Text
        yearTextView.setText(iYear);
        //Get the ImageView and set the name of the Object
        albumImageView.setImageResource(iImageID);

        //Intents
        final Intent albumDetailIntent = new Intent(context, DetailsAlbumActivity.class);

        //Put the properties of the Object to the intent
        albumDetailIntent.putExtra(context.getString(R.string.UIName), iName);
        albumDetailIntent.putExtra(context.getString(R.string.UIDesc), iDescription);
        albumDetailIntent.putExtra(context.getString(R.string.UIPhoto), iImageID);
        albumDetailIntent.putExtra(context.getString(R.string.UIYear), iYear);

        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(albumDetailIntent);
            }
        });

        // Return the whole list item layout so that it can be shown in
        // the ListView.
        return listItemView;
    }

}