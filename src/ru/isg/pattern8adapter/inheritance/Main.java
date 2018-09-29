package ru.isg.pattern8adapter.inheritance;

/**
 * Created by s.ivanov on 10.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		UsedInterface src = new Adapter();
		src.operation();
	}
}

class Adaptee {
	void adapteeOperation() {
		System.out.println("adaptee operation");
	}
}

interface UsedInterface {
	void operation();
}

class Adapter extends Adaptee implements UsedInterface {
	@Override
	public void operation() {
		adapteeOperation();
	}
}