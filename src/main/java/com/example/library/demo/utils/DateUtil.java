package com.example.library.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /* date = "2000-11-11 11:11:11" */
    public static Date parseStr2Date(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
