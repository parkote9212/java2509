package ch05.sec05;

public class LengthExample {
    public static void main(String[] args) {
        String ssn = "950624123012";
        int length = ssn.length();
String result = length==13 ? "이상 없음" : "다시 작성";
        System.out.println(result);
    }
}
