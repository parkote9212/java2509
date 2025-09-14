package ch09.sec03.exam02;

public class A {

	static class B {

		int field1 = 1;

		static int field2 = 2;

		B() {
			System.out.println("B 생성자실행");
		}

		void method1() {
			System.out.println("B-메소드 실행");
		}

		static void method2() {
			System.out.println("B-메소드2 실행");
		}
	}

}
