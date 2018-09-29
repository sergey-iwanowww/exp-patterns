package ru.isg.pattern8adapter.composition;

/**
 * Created by s.ivanov on 10.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Adapter src = new ConcreteAdapter(new Adaptee());
		src.operation();
	}
}

class Adaptee {
	void adapteeOperation() {
		System.out.println("adaptee operation");
	}
}

interface Adapter {
	void operation();
}

class ConcreteAdapter implements Adapter {
	Adaptee adaptee;
	public ConcreteAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	@Override
	public void operation() {
		adaptee.adapteeOperation();
	}
}