package ru.isg.pattern22singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by s.ivanov on 29.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		Singleton.getInstance();
		Singleton.getInstance();
		Singleton.getInstance();
		Singleton.getInstance();

		System.out.println(Singleton.counter);
	}
}

class Singleton {

	private static volatile Singleton instance;

	public static AtomicInteger counter = new AtomicInteger(0);

	private Singleton(){
		counter.incrementAndGet();
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}