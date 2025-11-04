package example.exarraylist;

import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println();

        cars.add(0, "Hyundai");
        System.out.println(cars);
        System.out.println();

        cars.set(0,"Kia");
        System.out.println(cars);
        System.out.println();

        cars.remove(0);
        System.out.println(cars);
        System.out.println();

        for (String i : cars) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println(cars.size());
        cars.clear();
        System.out.println(cars.size());



    }
}

