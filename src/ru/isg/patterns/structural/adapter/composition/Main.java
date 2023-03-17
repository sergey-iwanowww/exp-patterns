package ru.isg.patterns.structural.adapter.composition;

/**
 * Created by s.ivanov on 10.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		// use usual implementation
		UsedInteface usedInterface = new UsedInterfaceImpl();
		usedInterface.operation();

		// adapt new implementation
		usedInterface = new ConcreteAdapter(new Adaptee());
		usedInterface.operation();
	}
}

// Theory and example with composition

interface UsedInteface {
	void operation();
}

class UsedInterfaceImpl implements UsedInteface {
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

class ConcreteAdapter implements UsedInteface {
	Adaptee adaptee;
	public ConcreteAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	@Override
	public void operation() {
		adaptee.adapteeOperation();
	}
}