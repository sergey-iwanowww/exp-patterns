package ru.isg.pattern9decorator;

/**
 * Created by s.ivanov on 11.09.2018.
 */
public class Main {
	public static void main(String[] args) {
//		SampleInterface si = new SampleClass();
//		SampleInterface si = new ConcreteDecorator1(new SampleClass());
		SampleInterface si = new ConcreteDecorator2(new SampleClass());
		si.operation();
	}
}

interface SampleInterface {
	void operation();
}

class SampleClass implements SampleInterface {
	@Override
	public void operation() {
		System.out.println("operation");
	}
}

interface Decorator extends SampleInterface {

}

class ConcreteDecorator1 implements Decorator {
	SampleInterface sampleInterface;

	public ConcreteDecorator1(SampleInterface sampleInterface) {
		this.sampleInterface = sampleInterface;
	}

	@Override
	public void operation() {
		extraOperation();
		sampleInterface.operation();
	}
	private void extraOperation() {
		System.out.println("extra operation in decorator 1");
	}
}

class ConcreteDecorator2 implements Decorator {
	SampleInterface sampleInterface;

	public ConcreteDecorator2(SampleInterface sampleInterface) {
		this.sampleInterface = sampleInterface;
	}

	@Override
	public void operation() {
		extraOperation();
		sampleInterface.operation();
	}
	private void extraOperation() {
		System.out.println("extra operation in decorator 2");
	}
}