package com.vemergetech.androidlearning;

/**
 * Created by prashant on 19-Aug-17.
 */

public class Place {
    public String mNameOfPlace;
    public int mZipCode;
    public String mNameOfImage;
    public String mPopup;

    public Place(String startNameOfPlace, int startZipCode, String startNameOfImage, String startPopup){
        this.mNameOfImage = startNameOfImage;
        this.mNameOfPlace = startNameOfPlace;
        this.mPopup = startPopup;
        this.mZipCode = startZipCode;
    }
}
