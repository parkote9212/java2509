package ch14.sec06.exam02;

public class WaitNotifyExample {
    public static void main(String[] args) {
//        공유작업객체 생성
        WorkObject workObject = new WorkObject();
// 작업스레드 생성 실행 및 실행
        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }
}
