package ru.isg.patterns.creational.abstractfactory;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class Main {
}

// Theory

// Factory's interface
interface AbstractFactory {
	ProductA createProductA();
	ProductB createProductB();
}

// Implementation of factory's interface for products from the first family of products
class ConcreteFactory1 implements AbstractFactory {

	@Override
	public ConcreteProductA1 createProductA() {
		return new ConcreteProductA1();
	}

	@Override
	public ConcreteProductB1 createProductB() {
		return new ConcreteProductB1();
	}
}

// Implementation of factory's interface for products from the second family of products
class ConcreteFactory2 implements AbstractFactory {

	@Override
	public ConcreteProductA2 createProductA() {
		return new ConcreteProductA2();
	}

	@Override
	public ConcreteProductB2 createProductB() {
		return new ConcreteProductB2();
	}
}

// A product's interface
interface ProductA {
}

// Concrete product A from the first family
class ConcreteProductA1 implements ProductA {
}

// Concrete product A from the second family
class ConcreteProductA2 implements ProductA {
}

// B product's interface
interface ProductB {
}

// Concrete product B from the first family
class ConcreteProductB1 implements ProductB {
}

// Concrete product B from the second family
class ConcreteProductB2 implements ProductB {
}
