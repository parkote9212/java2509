package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch (week){
            case Calendar.MONDAY: strWeek = "월"; break;
            case Calendar.TUESDAY: strWeek = "월"; break;
            case Calendar.WEDNESDAY: strWeek = "월"; break;
            case Calendar.THURSDAY: strWeek = "월"; break;
            case Calendar.FRIDAY: strWeek = "월"; break;
            case Calendar.SATURDAY: strWeek = "월"; break;
            default: strWeek = "일";
        }

        int apPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if(apPm == Calendar.AM){
            strAmPm = "오전";
        }else {
            strAmPm = "오후";
        }

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.println(year + " " + month + " " + day);
        System.out.println(strWeek + " " +  strAmPm);
        System.out.println(hour + " " + minute + " " + second);

    }
}
