package example.exscanner;

import java.util.Scanner;

public class Scan1 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        //입력값 읽기
        String userName = myObj.nextLine();
        System.out.println("Username is: " + userName);
    }
}
