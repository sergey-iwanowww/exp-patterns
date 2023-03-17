package ru.isg.patterns.behavioral.mediator;

/**
 * Created by s.ivanov on 22.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		ConcreteMediator m = new ConcreteMediator();

		Client cl1 = new ConcreteClient1(m);
		Client cl2 = new ConcreteClient2(m);

		m.setClient1(cl1);
		m.setClient2(cl2);

		cl1.sendMessage("Hello");
		cl2.sendMessage("Yes, Hello");
	}
}

// Theory and example

interface Mediator {
	void send(Client sender, String message);
}

class ConcreteMediator implements Mediator {

	private Client client1;
	private Client client2;

	public void setClient1(Client client1) {
		this.client1 = client1;
	}

	public void setClient2(Client client2) {
		this.client2 = client2;
	}

	@Override
	public void send(Client sender, String message) {
		if (sender instanceof ConcreteClient1) {
			client2.handleMessage(message);
		} else if (sender instanceof ConcreteClient2) {
			client1.handleMessage(message);
		}
	}
}

interface Client {
	void handleMessage(String message);
	void sendMessage(String message);
}

abstract class AbstractClient implements Client {
	protected Mediator mediator;

	public void sendMessage(String message) {
		mediator.send(this, message);
	}
}

class ConcreteClient1 extends AbstractClient {

	public ConcreteClient1(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void handleMessage(String message) {
		System.out.println("handle in client1: " + message);
	}
}

class ConcreteClient2 extends AbstractClient {

	public ConcreteClient2(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void handleMessage(String message) {
		System.out.println("handle in client2: " + message);
	}
}