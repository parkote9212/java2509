package example.exscanner;


import java.util.Scanner;

public class Scan2 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name, age and salary");

        String name = myObj.nextLine();

        int age = myObj.nextInt();
        double salay = myObj.nextDouble();

        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Salay : " + salay);
    }
}
