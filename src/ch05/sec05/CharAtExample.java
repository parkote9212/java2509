package ch05.sec05;

public class CharAtExample {
    public static void main(String[] args) {
        String ssn = "9506242230123";
        char sex = ssn.charAt(6);
        switch (sex) {
            case '1','3' -> System.out.println("남자");
            case '2','4' -> System.out.println("여자");
        }
    }
}
