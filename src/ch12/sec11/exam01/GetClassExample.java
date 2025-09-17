package ch12.sec11.exam01;

public class GetClassExample {
    public static void main(String[] args) throws Exception {

//        리플렉션 클래스 객체 얻기
//     1번 클래스에서 객체 얻기
        Class clazz = Car.class;

//   2번 클래스에서 객체 얻기
        Class clazz2 = Class.forName("ch12.sec11.exam01.Car");

//        3번 객체로부터 객체 얻기
        Car car = new Car();
        Class clazz3 = car.getClass();

        System.out.println("패키지 : " + clazz.getPackage().getName());
//        아래 코드는 안드로이드 전용이므로 주의
//        System.out.println("패키지 : " + clazz.getPackageName());

        System.out.println("클래스 간단 이름 : " + clazz2.getSimpleName());

        System.out.println("클래스 전체 이름 : " + clazz3.getName());
    }
}
