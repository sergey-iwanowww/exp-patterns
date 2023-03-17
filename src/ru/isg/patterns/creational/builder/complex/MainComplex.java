package ru.isg.patterns.creational.builder.complex;

/**
 * Created by s.ivanov on 06.09.2018.
 */
public class MainComplex {
	public static void main(String[] args) {
		Director d = new Director();
		d.setCarBuilder(new MercedesCarBuilder());
		d.buildCar();
		System.out.println(d.getCar());
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

abstract class CarBuilder {
	protected Car car;

	public void createCar() {
		car = new Car();
	}

	public Car getCar() {
		return car;
	}

	public abstract void buildName();

	public abstract void buildTransmission();

	public abstract void buildMaxSpeed();
}

class FordCarBuilder extends CarBuilder {

	@Override
	public void buildName() {
		car.setName("Ford");
	}

	@Override
	public void buildTransmission() {
		car.setTransmission(Transmission.MANUAL);
	}

	@Override
	public void buildMaxSpeed() {
		car.setMaxSpeed(120);
	}
}

class MercedesCarBuilder extends CarBuilder {

	@Override
	public void buildName() {
		car.setName("Mercedes");
	}

	@Override
	public void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	public void buildMaxSpeed() {
		car.setMaxSpeed(200);
	}
}

class Director {

	private CarBuilder carBuilder;

	public void setCarBuilder(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}
	public Car getCar() {
		return carBuilder.getCar();
	}
	public void buildCar() {
		carBuilder.createCar();
		carBuilder.buildMaxSpeed();
		carBuilder.buildName();
		carBuilder.buildTransmission();
	}
}