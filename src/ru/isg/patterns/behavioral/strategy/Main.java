package ru.isg.patterns.behavioral.strategy;

/**
 * Created by s.ivanov on 25.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Context c = new Context();
		c.setStrategy(new ConcreteStrategy1());
		c.operation();

		c.setStrategy(new ConcreteStrategy2());
		c.operation();
	}
}

// Theory and example
class Context {
	Strategy strategy;
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void operation() {
		System.out.println("Calc result using ");
		strategy.operation();
	}
}

interface Strategy {
	void operation();
}

class ConcreteStrategy1 implements Strategy {
	@Override
	public void operation() {
		System.out.println("strategy 1");
	}
}

class ConcreteStrategy2 implements Strategy {
	@Override
	public void operation() {
		System.out.println("strategy 2");
	}
}