package ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1, 자바 학습,참조 타입 String을 학습합니다., 홍길동";

        String[] tokens = board.split(",");

        System.out.println(tokens[0]);
        System.out.println(tokens[1]);
        System.out.println(tokens[2]);
        System.out.println(tokens[3]);
        System.out.println();

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }

// 올바른 코드
        for (String token : tokens) {
            System.out.println(token);
        }

    }
}
