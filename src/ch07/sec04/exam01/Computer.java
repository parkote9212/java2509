package ch07.sec04.exam01;

public class Computer extends Calculator {

	@Override
	public double areaCircle(double r) {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터 객체의 areaCircle() 실행");

		return Math.PI * r * r;
	}
}
