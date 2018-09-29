package ru.isg.pattern6prototype;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class Main {
	public static void main(String[] args) {

	}

	// теория
	// в java данный шаблон реализован: Object.clone
}

// пример
interface Copyable {
	Object copy();
}

class Human implements Copyable {
	int age;
	String name;

	public Human(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public Human copy() {
		return new Human(age, name);
	}
}