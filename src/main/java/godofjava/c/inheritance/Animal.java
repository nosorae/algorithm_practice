package godofjava.c.inheritance;

public class Animal {
    String name;
    String kind;
    int legCount;
    int iq;
    boolean hasWing;
    String barkSound;

    public void move() {
        System.out.println("move Animal");
    }

    public void eatFood() {
        System.out.println("eatFood Animal");
    }
}

class Dog extends Animal {

    public void move() {
        System.out.println("move Dog");
    }

    public void eatFood() {
        System.out.println("eatFood Dog");
    }
}

class Cat extends Animal {
    public void move() {
        System.out.println("move Cat");
    }

    public void eatFood() {
        System.out.println("eatFood Cat");
    }
}

