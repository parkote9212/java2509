package ch09.test;

public class ActionExample {
    public static void main(String[] args) {
        Action action = new Action() {
            @Override
            public void work() {
                System.out.println("일을 합니다.");
                            }
        };
        action.work();
    }
}
