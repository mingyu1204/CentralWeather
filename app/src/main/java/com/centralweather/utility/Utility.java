package com.centralweather.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Amber_Chen on 2020-03-21.
 */
public class Utility {

    public static String getTimeFormat(long timeStamp) {
        if (timeStamp == 0)
            return "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss", Locale.TAIWAN);

        return format.format(new Date(timeStamp));
    }
}
