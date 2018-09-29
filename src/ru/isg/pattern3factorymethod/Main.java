package ru.isg.pattern3factorymethod;

import java.util.Date;

/**
 * Created by s.ivanov on 04.09.2018.
 */
public class Main {
	public static void main(String[] args) {
//		WatchProducer p = getWatchProducer("Digital");
//		Watch w = p.createWatch();


	}

	private static WatchProducer getWatchProducer(String producer) {
		if (producer.equals("Digital")) {
			return new DigitalWatchProducer();
		} else if (producer.equals("Rome")) {
			return new RomeWatchProducer();
		} else {
			throw new IllegalArgumentException("Producer not supported: " + producer);
		}
	}

	private static Watch createWatch(String name) {
		if (name.equals("Digital")) {
			return new DigitalWatch();
		} else if (name.equals("Rome")) {
			return new RomeWatch();
		} else {
			throw new IllegalArgumentException("Name not supported: " + name);
		}
	}
}

// Теория
interface Creator {
	Product factoryMethod();
}

class ConcreteCreator implements Creator {
	@Override
	public ConcreteProduct factoryMethod() {
		return new ConcreteProduct();
	}
}

interface Product {
}

class ConcreteProduct implements Product {
}

// Пример
interface Watch {
	void showTime();
}

class DigitalWatch implements Watch {
	@Override
	public void showTime() {
		System.out.println(new Date());
	}
}

class RomeWatch implements Watch {
	@Override
	public void showTime() {
		System.out.println("Rome: " + new Date());
	}
}

interface WatchProducer {
	Watch createWatch();
}

class DigitalWatchProducer implements WatchProducer {
	@Override
	public Watch createWatch() {
		return new DigitalWatch();
	}
}

class RomeWatchProducer implements WatchProducer {
	@Override
	public Watch createWatch() {
		return new RomeWatch();
	}
}