package example.exanonymous;

interface Greeting {
    void sayHello ();
}

public class Anon2 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World");
            }
        };

        greeting.sayHello();
    }
}
