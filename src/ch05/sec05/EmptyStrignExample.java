package ch05.sec05;

public class EmptyStrignExample {
    public static void main(String[] args) {
        String hobby = "";
        if (hobby.equals("")) {
            System.out.println("변수가 참조하는 String 객채는 빈 문자열");
        }
    }
}
