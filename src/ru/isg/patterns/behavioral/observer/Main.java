package ru.isg.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.ivanov on 22.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		Observable observable = new Observable();

		Observer o1 = new ConcreteObserver1();
		Observer o2 = new ConcreteObserver2();

		observable.addObserver(o1);
		observable.addObserver(o2);

		observable.changeState(1, "56");
	}
}

// Theory and example

interface Observer {
	void handleEvent(String eventData);
}

class ConcreteObserver1 implements Observer {
	@Override
	public void handleEvent(String eventData) {
		System.out.println("event in concreteObserver1 from observable: " + eventData);
	}
}

class ConcreteObserver2 implements Observer {
	@Override
	public void handleEvent(String eventData) {
		System.out.println("event in concreteObserver2 from observable: " + eventData);
	}
}

class Observable {

	private int stateField1;
	private String stateField2;

	private List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	public void changeState(int stateField1, String stateField2) {
		this.stateField1 = stateField1;
		this.stateField2 = stateField2;
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer o : observers) {
			o.handleEvent("stateField1 = " + stateField1 + ", stateField2 = " + stateField2);
		}
	}
}