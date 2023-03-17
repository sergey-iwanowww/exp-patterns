package ru.isg.patterns.structural.adapter.inheritance;

/**
 * Created by s.ivanov on 10.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		// use usual implementation
		UsedInterface usedInterface = new UsedInterfaceImpl();
		usedInterface.operation();

		// adapt new implementation
		usedInterface = new Adapter();
		usedInterface.operation();
	}
}

// Theory and example with inheritance

interface UsedInterface {
	void operation();
}

class UsedInterfaceImpl implements UsedInterface {
	@Override
	public void operation() {
		System.out.println("old operation implementation");
	}
}

class Adaptee {
	void adapteeOperation() {
		System.out.println("adaptee operation");
	}
}

class Adapter extends Adaptee implements UsedInterface {
	@Override
	public void operation() {
		adapteeOperation();
	}
}