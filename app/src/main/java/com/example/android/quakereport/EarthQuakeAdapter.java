package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by sajal on 02-06-2018.
 */

public class EarthQuakeAdapter extends ArrayAdapter<QuakeReportC>{

    public EarthQuakeAdapter(EarthquakeActivity earthquakes, ArrayList<QuakeReportC> earthquakes1){
        super(earthquakes,0,earthquakes1);
    }
    private static final String LOCATION_SEPARATOR = " of ";
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    DecimalFormat formatter = new DecimalFormat("0.00");
    String output = formatter.format(2.3234);
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);


        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);



    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListView = convertView;


        if (ListView == null) {

            ListView = LayoutInflater.from(getContext()).inflate(

                    R.layout.earthquakerow, parent, false);
        }
        QuakeReportC currentQuakeReportC = getItem(position);
        TextView magnitudeView = (TextView) ListView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentQuakeReportC.getMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);

        String primaryLocation;
        String locationOffset;
        String originalLocation = currentQuakeReportC.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) ListView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);
        TextView locationOffsetView = (TextView) ListView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);


        Date dateObject = new Date(currentQuakeReportC.getTimeInMilliseconds());
        // Find the TextView with view ID date
        TextView dateView = (TextView) ListView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) ListView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentQuakeReportC.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        magnitudeCircle.setColor(magnitude1Color);
        int magnitude2Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
        magnitudeCircle.setColor(magnitude2Color);
        int magnitude3Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
        magnitudeCircle.setColor(magnitude3Color);
        int magnitude4Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
        magnitudeCircle.setColor(magnitude4Color);
        int magnitude5Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
        magnitudeCircle.setColor(magnitude5Color);
        int magnitude6Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
        magnitudeCircle.setColor(magnitude6Color);
        int magnitude7Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
        magnitudeCircle.setColor(magnitude7Color);
        int magnitude8Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
        magnitudeCircle.setColor(magnitude8Color);
        int magnitude9Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
        magnitudeCircle.setColor(magnitude9Color);
        return ListView;
    }


}


