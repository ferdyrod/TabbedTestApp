package com.ferdyrodriguez.toptenapps.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ferdyrod on 2/1/17.
 */

public class Utils {

    public static final String ITUNES_BASE_URL = "https://itunes.apple.com/";
    public static final String FREE = "Free";
    public static final String COUNTRY = "es";

    public static String verifyPrice(String price) {
        Double newPrice = Double.valueOf(price);
        if(newPrice > 0){
            return "€ " + newPrice.toString();
        } else {
            return FREE;
        }
    }

    public static String formatDate(String releaseDate) {
        String date = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date convertedDate = simpleDateFormat.parse(releaseDate);
            SimpleDateFormat sdfdate = new SimpleDateFormat("dd/MM/yyyy");
            date = sdfdate.format(convertedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
