package ru.isg.pattern23bridge;

/**
 * Created by s.ivanov on 29.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		CarBody carBody = new Hatchback(new Skoda());

		System.out.println(carBody.getDetails());
	}
}

// Теория
class Abstraction {

	private Implementation impl;

	public Abstraction(Implementation impl) {
		this.impl = impl;
	}

	public void feature1() {
		System.out.println("feature 1");
		impl.method1();
		impl.method2();
	}

	public void feature2() {
		System.out.println("feature 2");
		impl.method3();
	}
}

class Implementation {

	public void method1() {
		System.out.println("Impl method1");
	}

	public void method2() {
		System.out.println("Impl method2");
	}

	public void method3() {
		System.out.println("Impl method3");
	}
}

// Пример
abstract class CarBody {

	protected Brand brand;

	public CarBody(Brand brand) {
		this.brand = brand;
	}
	public abstract String getDetails();
}

class Sedan extends CarBody {

	public Sedan(Brand brand) {
		super(brand);
	}

	@Override
	public String getDetails() {
		return brand.getName() + " Sedan";
	}
}

class Hatchback extends CarBody {

	public Hatchback(Brand brand) {
		super(brand);
	}

	@Override
	public String getDetails() {
		return brand.getName() + " Hatchback";
	}
}

interface Brand {
	String getName();
}

class Skoda implements Brand {

	@Override
	public String getName() {
		return "Skoda";
	}
}

class BMW implements Brand {

	@Override
	public String getName() {
		return "BMW";
	}
}