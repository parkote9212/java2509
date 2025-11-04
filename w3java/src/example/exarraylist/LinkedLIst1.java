package example.exarraylist;

import java.util.LinkedList;

public class LinkedLIst1 {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println();

        cars.addFirst("AddFirst");
        cars.addLast("AddLast");
        System.out.println(cars);
        System.out.println();
        System.out.println(cars.getFirst());
        System.out.println(cars.getLast());
        System.out.println();
        cars.removeFirst();
        cars.removeLast();
        System.out.println(cars);
    }
}
