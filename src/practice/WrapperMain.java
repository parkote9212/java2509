package practice;

import java.util.ArrayList;

public class WrapperMain {
    public WrapperMain() {
        ArrayList<Integer> myNums = new ArrayList<>();
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';

        System.out.println(myInt + ", " + myDouble + ", " + myChar);
        System.out.println(myInt.intValue());
        System.out.println(myDouble.doubleValue());
        System.out.println(myChar.charValue());
        System.out.println("------------");
        myInt = 100;
        String myString = myInt.toString();
        System.out.println("값 : " + myString);
        System.out.println("길이 : " + myString.length());
    }
}
