package ch07.sec04.ex01;

public class Computer extends Calculator {

    @Override
    public double areaCircle(double r){
        System.out.println("컴퓨터 객체의 메소드 실행");
        return Math.PI * r * r;
    }
}
