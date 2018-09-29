package ru.isg.pattern4abstractfactory;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class Main {
}

// Теория
interface AbstractFactory {
	ProductA createProductA();
	ProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {

	@Override
	public ProductA createProductA() {
		return new ConcreteProductA1();
	}

	@Override
	public ProductB createProductB() {
		return new ConcreteProductB1();
	}
}

class ConcreteFactory2 implements AbstractFactory {

	@Override
	public ProductA createProductA() {
		return new ConcreteProductA2();
	}

	@Override
	public ProductB createProductB() {
		return new ConcreteProductB2();
	}
}

interface ProductA {
}

class ConcreteProductA1 implements ProductA {
}

class ConcreteProductA2 implements ProductA {
}

interface ProductB {
}

class ConcreteProductB1 implements ProductB {
}

class ConcreteProductB2 implements ProductB {
}

// Пример
