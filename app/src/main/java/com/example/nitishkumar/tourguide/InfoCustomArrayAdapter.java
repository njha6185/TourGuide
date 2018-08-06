package com.example.nitishkumar.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class InfoCustomArrayAdapter extends ArrayAdapter<Info>{

    public InfoCustomArrayAdapter(Context context, ArrayList<Info> listDetail)
    {
        super(context,0, listDetail);
    }
/************************* it returns the populated view to fragment ********************/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Info currentInfo = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.placeNameText);
        nameTextView.setSelected(true);
        nameTextView.setText(currentInfo.getPlaceName());

        TextView nearestMetroTextView = (TextView) listItemView.findViewById(R.id.nearestMetroText);
        nearestMetroTextView.setSelected(true);
        String metroText = listItemView.getResources().getString(R.string.nearest_metro) + currentInfo.getNearestMetro();
        nearestMetroTextView.setText(metroText);

        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.metroDistText);
        distanceTextView.setSelected(true);
        String metroDistText = listItemView.getResources().getString(R.string.metro_dist_text) +currentInfo.getDistanceFromMetro();
        distanceTextView.setText(metroDistText);

        ImageView placeImageView = (ImageView) listItemView.findViewById(R.id.listItemImage);
        placeImageView.setImageResource(currentInfo.getPlaceImageResourceID());

        return listItemView;
    }
}