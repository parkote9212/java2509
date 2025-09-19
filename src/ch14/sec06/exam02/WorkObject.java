package ch14.sec06.exam02;

public class WorkObject {
    public synchronized void methodA() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": methodA 작업 실행");
        notify(); // 다른 스레드 실행대기

        try {
            wait(); // 자기 스레드 일시정지
        } catch (InterruptedException e) {
        }
    }

    public synchronized void methodB() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": methodB 작업 실행");
        notify(); // 다른 스레드 실행대기

        try {
            wait(); // 자기 스레드 일시정지
        } catch (InterruptedException e) {
        }
    }
}
