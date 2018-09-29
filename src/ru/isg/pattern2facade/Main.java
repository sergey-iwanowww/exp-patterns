package ru.isg.pattern2facade;

/**
 * Created by s.ivanov on 04.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		Computer computer = new Computer();
		computer.copy();
	}
}

// составная часть системы
class Power {
	void on() {
		System.out.println("On");
	}
	void off() {
		System.out.println("Off");
	}
}

// составная часть системы
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

// составная часть системы
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

// фасад системы (инкапсулирует работу системы, скрывакет сложность)
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