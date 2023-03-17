package ru.isg.patterns.structural.facade;

/**
 * Created by s.ivanov on 04.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		Computer computer = new Computer();
		computer.copy();
	}
}

// Example

// Part of the complex system
class Power {
	void on() {
		System.out.println("On");
	}
	void off() {
		System.out.println("Off");
	}
}

// Part of the complex system
class DVDRom {
	private boolean data = false;
	boolean hasData() {
		return data;
	}
	void load() {
		data = true;
	}
	void unload() {
		data = false;
	}
}

// Part of the complex system
class HDD {
	void copyFromDVDRom(DVDRom dvdRom) {
		if (dvdRom.hasData()) {
			System.out.println("copying from DVD ...");
		}
		else {
			System.out.println("insert DVD");
		}
	}
}

// Facade (it hides unnecessary functions and extra complexity)
class Computer {

	Power power = new Power();
	DVDRom dvdRom = new DVDRom();
	HDD hdd = new HDD();

	void copy() {

		power.on();

		dvdRom.load();

		hdd.copyFromDVDRom(dvdRom);
	}
}