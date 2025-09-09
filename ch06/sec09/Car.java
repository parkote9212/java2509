package ch06.sec09;

public class Car {

	String model;
	int speed;

	Car(String model) {
		this.model = model;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	void run() {
		this.setSpeed(100);
		System.out.println(this.model + " " + this.speed);
	}

}
