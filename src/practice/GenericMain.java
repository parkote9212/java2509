package practice;

public class GenericMain {
    public GenericMain() {

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello");
        System.out.println("값은 " + stringBox.getValue());
        System.out.println(stringBox.getValue().length());

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(159);
        System.out.println(integerBox.getValue());

        String[] names = {"A", "B", "C"};
        Integer[] numbers = {1, 2, 3, 4};

        printArray(names);
        printArray(numbers);
        Integer[] intNums = {2,2,3};
        Stats<Integer> intStats = new Stats<>(intNums);
        System.out.println(intStats.average());


    }

    private static <T> void printArray(T[] names) {

        for (T str : names) {
            System.out.print(str);
        }
        System.out.println();
    }

}
