package example.exexception;

public class MultiExcep1 {
    public static void main(String[] args) {
        try {
            int[] number = {1,2,3};
            System.out.println(number[10]);
            int result = 10 / 0;
        }

        catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("Math or Array error");
        }

//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Array index does not exist");
//        } catch (ArithmeticException e){
//            System.out.println("Cannot divede by zero");
//        } catch (Exception e){
//            System.out.println("Somethis else went wrong");
//        }
    }
}
