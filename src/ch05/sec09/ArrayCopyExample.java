package ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray = {"java", "array", "copy"};

        String[] newStroArray = new String[5];

        System.arraycopy(oldStrArray, 0, newStroArray, 0, oldStrArray.length);

        for (String str:newStroArray){
            System.out.println(str);
        }
    }
}
