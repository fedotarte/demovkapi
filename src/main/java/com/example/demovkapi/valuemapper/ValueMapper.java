package com.example.demovkapi.valuemapper;

import org.springframework.web.util.UriUtils;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ValueMapper {

    public String parseStringToURL(String textMessage) {
        String parsedURL = textMessage;
        try {
            parsedURL = UriUtils.encode(textMessage, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return parsedURL;
    }

    public LocalDate parseStringBirthDayToLocalDate(String stringBdate) {
        int day = 1;
        int month = 1;
        int year = 1970;
        LocalDate localDate;
        //check for null and return default value
        if (stringBdate == null)
            return LocalDate.of(1940, 1, 1);


        String[] parted = stringBdate.split("\\.");
        if (parted.length > 2)
            if (parted[2] != null && parted[2].length() < 4) {

                //check if birthday before '00s
                if (Integer.parseInt(parted[2]) > Calendar.getInstance().get(Calendar.YEAR) % 100) {
                    parted[2] = "19".concat(parted[2]);
                } else {
                    parted[2] = "20".concat(parted[2]);
                }
                year = Integer.parseInt(parted[2]);
            }
        day = Integer.parseInt(parted[0]);
        month = Integer.parseInt(parted[1]);
        localDate = LocalDate.of(year, month, day);
        return localDate;
    }



}
