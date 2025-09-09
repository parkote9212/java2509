package ch03.sec01;

public class IncreaseDecreaseOperatorExapmle {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;

        x++;
//        x=11
        ++x;
//        x=12

        System.out.println("x=" + x);

        System.out.println("----------------------------");
        y--;
//        y=9
        --y;
//        y=8
        System.out.println("y=" + y);

        System.out.println("-----------------------------");
        z = x++;
//        z = 12 , x=13
        System.out.println("z=" +z);
        System.out.println("x=" +x);

        System.out.println("-----------------------------");
        z = ++x + y++;
//        x=14 y=10 z=22

        System.out.println("z=" + z);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }
}
