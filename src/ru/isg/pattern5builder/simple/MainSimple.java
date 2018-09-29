package ru.isg.pattern5builder.simple;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class MainSimple {
	public static void main(String[] args) {
		Car car = new CarBuilder().buildName("Vaz").buildMaxSpeed(120).buildTransmission(Transmission.AUTO).build();
		System.out.println(car);
	}
}


// теория
interface Builder {
	Builder buildPart1();
	Builder buildPart2();
}

//class ConcreteBuilder implements Builder {
//	public Product buildPart1() {
//		System.out.println("build part 1");
//	}
//	public Product buildPart2() {
//		System.out.println("build part 2");
//	}
//}

class Product {

}

// пример
enum Transmission {
	MANUAL,
	AUTO
}

class Car {
	String name;
	Transmission transmission;
	int maxSpeed;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", transmission=" + transmission +
				", maxSpeed=" + maxSpeed +
				'}';
	}
}

class CarBuilder {
	String n;
	Transmission t;
	int m;
	CarBuilder buildName(String n) {
		this.n = n;
		return this;
	}
	CarBuilder buildTransmission(Transmission t) {
		this.t = t;
		return this;
	}
	CarBuilder buildMaxSpeed(int m) {
		this.m = m;
		return this;
	}
	Car build() {
		Car car = new Car();
		car.setMaxSpeed(m);
		car.setName(n);
		car.setTransmission(t);
		return car;
	}
}