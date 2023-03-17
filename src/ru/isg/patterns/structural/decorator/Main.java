package ru.isg.patterns.structural.decorator;

/**
 * Created by s.ivanov on 11.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		UsedInterface usedInterface = new UsedClass();
		usedInterface.operation();

		usedInterface = new ConcreteDecorator1(usedInterface);
		usedInterface.operation();

		usedInterface = new ConcreteDecorator2(usedInterface);
		usedInterface.operation();
	}
}

// Theory and example

interface UsedInterface {
	void operation();
}

class UsedClass implements UsedInterface {
	@Override
	public void operation() {
		System.out.println("operation");
	}
}

abstract class BaseDecorator implements UsedInterface {

	protected UsedInterface usedInterface;

	public BaseDecorator(UsedInterface usedInterface) {
		this.usedInterface = usedInterface;
	}
}

class ConcreteDecorator1 extends BaseDecorator {

	public ConcreteDecorator1(UsedInterface usedInterface) {
		super(usedInterface);
	}

	@Override
	public void operation() {
		beforeExtraOperation();
		usedInterface.operation();
		afterExtraOperation();
	}
	private void beforeExtraOperation() {
		System.out.println("before extra operation in decorator 1");
	}

	private void afterExtraOperation() {
		System.out.println("after extra operation in decorator 1");
	}
}

class ConcreteDecorator2 extends BaseDecorator {

	public ConcreteDecorator2(UsedInterface usedInterface) {
		super(usedInterface);
	}

	@Override
	public void operation() {
		beforeExtraOperation();
		usedInterface.operation();
	}
	private void beforeExtraOperation() {
		System.out.println("before extra operation in decorator 2");
	}
}