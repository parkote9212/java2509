package example.exexception;

public class Excep1 {
    public static void main(String[] args) {
        try {
            int[] myNums = {1, 2, 3};
            System.out.println(myNums[10]);
        } catch (Exception e) {
            System.out.println("Somthing went wrong");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }
    }
}
