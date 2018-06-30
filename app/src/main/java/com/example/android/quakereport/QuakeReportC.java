package com.example.android.quakereport;

import java.text.SimpleDateFormat;

/**
 * Created by sajal on 02-06-2018.
 */

public class QuakeReportC {
    private double mMagnitude;
    private String mLocation;
    private String mDate;
    public long mTimeInMilliseconds;
    private String mUrl;


    public QuakeReportC(double magnitude, String location, long timeInMilliseconds,String url){
        mMagnitude=magnitude;
        mLocation=location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }
    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
    public String getUrl() {return mUrl;}
}
