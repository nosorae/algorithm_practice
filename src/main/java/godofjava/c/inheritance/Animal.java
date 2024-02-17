package godofjava.c.inheritance;

// GodOfJava Vol1. 10장
public class Animal {
    String name;
    String kind;
    int legCount;
    int iq;
    boolean hasWing;
    String barkSound;

    public Animal(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("move Animal");
    }

    public void eatFood() {
        System.out.println("eatFood Animal");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void move() {
        System.out.println("move Dog");
    }

    public void eatFood() {
        System.out.println("eatFood Dog");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void move() {
        System.out.println("move Cat");
    }

    public void eatFood() {
        System.out.println("eatFood Cat");
    }
}

