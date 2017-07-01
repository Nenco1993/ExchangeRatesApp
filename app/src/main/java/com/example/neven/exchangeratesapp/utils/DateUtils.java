package com.example.neven.exchangeratesapp.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Neven on 1.7.2017..
 */
public class DateUtils {

    public List<String> getDates() {    // returns a list of last 7 days

        List<String> listDate = new ArrayList<>();

        Calendar calendarToday = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String today = simpleDateFormat.format(calendarToday.getTime());

        Calendar calendarDayBefore = Calendar.getInstance();
        calendarDayBefore.setTime(calendarDayBefore.getTime());

        int daysCounter = 0;

        while (daysCounter <= 7) {

            if (daysCounter == 0) {  // means that its present day
                listDate.add(today);
            } else {                       // subtracts 1 day after each pass
                calendarDayBefore.add(Calendar.DAY_OF_MONTH, -1);
                Date dateMinusOneDay = calendarDayBefore.getTime();
                String oneDayAgo = simpleDateFormat.format(dateMinusOneDay);

                listDate.add(oneDayAgo);

            }

            daysCounter++;
        }

        return listDate;

    }


}
