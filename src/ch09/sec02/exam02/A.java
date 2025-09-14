package ch09.sec02.exam02;

public class A {

	class B {
		int field1 = 1;

		static int field2 = 2;

		B() {
			System.out.println("A-B생성자 실행");
		}

//		인스턴스 메소드
		void method1() {
			System.out.println("A-B 메소드1 실행");
		}

		static void method2() {
			System.out.println("A-B 정적 메소드2 실행");
		}
	}

//	인스턴스 메소드
	void useB() {
//		B 객체 생성 및 인스턴스 필드 및 메소드 사용
		B b = new B();
		System.out.println(b.field1);
		b.method1();

		System.out.println(B.field2);
		B.method2();
	}

}
