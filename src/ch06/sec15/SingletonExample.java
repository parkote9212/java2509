package ch06.sec15;

public class SingletonExample {
	public static void main(String[] args) {

		Singleton obj1 = Singleton.getSingleton();
		Singleton obj2 = Singleton.getSingleton();

		if (obj1 == obj2) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
	}
}
