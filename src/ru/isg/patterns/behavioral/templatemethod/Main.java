package ru.isg.patterns.behavioral.templatemethod;

/**
 * Created by s.ivanov on 24.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		AbstractClass as = new ConcreteClass2();
		as.templateMethod();
	}
}

// Theory and example
abstract class AbstractClass {
	public final void templateMethod() {
		System.out.println("Read from");
		differPart();
		System.out.println("file");
	}
	protected abstract void differPart();
}

class ConcreteClass1 extends AbstractClass {
	@Override
	protected void differPart() {
		System.out.println("doc");
	}
}

class ConcreteClass2 extends AbstractClass {
	@Override
	protected void differPart() {
		System.out.println("pdf");
	}
}