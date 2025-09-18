package practice;

public class Trymain {
    public Trymain() {


        try {
            int[] myNums = {1, 2, 3};
            System.out.println(myNums[10]);
            int result = 10 / 0;

       } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("끝");
        }

        checkAge(15);
        checkAge(20);


    }

    private void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("투표권이 없습니다.");
        } else {
            System.out.println("투표가능");
        }
    }

}
