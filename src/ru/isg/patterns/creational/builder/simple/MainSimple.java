package ru.isg.patterns.creational.builder.simple;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class MainSimple {
	public static void main(String[] args) {
		Car car = new CarBuilder()
				.buildName("Vaz")
				.buildMaxSpeed(120)
				.buildTransmission(Transmission.AUTO)
				.build();
		System.out.println(car);
	}
}


// Theory

// Builder's interface
interface Builder {
	Builder buildPart1();
	Builder buildPart2();
}

// Impl
class ConcreteBuilder implements Builder {
	public Builder buildPart1() {
		System.out.println("build part 1");
		return this;
	}
	public Builder buildPart2() {
		System.out.println("build part 2");
		return this;
	}
}

// Example
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

	private String name;
	private Transmission transmission;
	private int maxSpeed;

	public CarBuilder buildName(String name) {
		this.name = name;
		return this;
	}

	public CarBuilder buildTransmission(Transmission transmission) {
		this.transmission = transmission;
		return this;
	}

	public CarBuilder buildMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		return this;
	}

	Car build() {
		Car car = new Car();
		car.setMaxSpeed(maxSpeed);
		car.setName(name);
		car.setTransmission(transmission);
		return car;
	}
}