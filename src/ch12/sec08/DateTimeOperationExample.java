package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println("현재 : " + now.format(dtf));

        LocalDateTime result1 = now.plusYears(1);
        System.out.println("1년뒤 : " + result1.format(dtf));

        LocalDateTime result2 = now.minusMonths(2);
        System.out.println("2달 전 : " + result2.format(dtf));


        LocalDateTime result3 = now.plusDays(7);
        System.out.println("7일뒤 : " + result3.format(dtf));

    }
}
