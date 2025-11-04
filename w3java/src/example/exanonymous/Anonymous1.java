package example.exanonymous;

class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

public class Anonymous1 {
    public static void main(String[] args) {
        Animal animal = new Animal(){
            @Override
            public void makeSound() {
                System.out.println("Woof woof");
            }
        };

        animal.makeSound();

    }
}
