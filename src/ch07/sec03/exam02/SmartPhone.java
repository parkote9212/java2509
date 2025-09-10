package ch07.sec03.exam02;

public class SmartPhone extends Phone {

	public SmartPhone(String model, String color) {
		super(model, color);
		System.out.println("매개변수 스마트폰 생성자 실행");
	}
}
