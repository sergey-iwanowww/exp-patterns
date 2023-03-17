package ru.isg.patterns.creational.prototype;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class Main {
    public static void main(String[] args) {

        Human alex = new Human(20, "Alex");

        Human dave = (Human) alex.copy();

        System.out.println("alex = " + alex + ", dave = " + dave);
    }
}

// Example
// в java данный шаблон реализован: Object.clone

interface Copyable {
    Copyable copy();
}

class Human implements Copyable {

    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human(Human human) {
        super();
        this.age = human.age;
        this.name = human.name;
    }

    @Override
    public Copyable copy() {
        return new Human(this);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}