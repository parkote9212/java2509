package ch07.sec05.exam02;

public class ChildeExample {

	public static void main(String[] args) {

		Child child = new Child();

		Parent parent = child;

		parent.method1();
		parent.method2();
//		parent.method3();
	}
}
