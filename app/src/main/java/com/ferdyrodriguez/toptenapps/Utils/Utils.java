package com.ferdyrodriguez.toptenapps.Utils;

/**
 * Created by ferdyrod on 2/1/17.
 */

public class Utils {

    public static final String ITUNES_BASE_URL = "https://itunes.apple.com/";
    public static final String FREE = "Free";
    public static final String NO_PRICE = "0.00000";

    public static String verifyPrice(String price) {

        Double newPrice = Double.valueOf(price);

        if(newPrice > 0){
            return "€ " + newPrice.toString();
        } else {
            return FREE;
        }
    }

}
