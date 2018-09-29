package ru.isg.pattern15state;

/**
 * Created by s.ivanov on 24.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Context c = new Context();
		c.changeState(new ConcreteState1());

		c.method1();
		c.method1();
		c.method1();
		c.method1();
		c.method1();
		c.method1();
	}
}

class Context {
	private State state;
	void changeState(AbstractState state) {
		state.setContext(this);
		this.state = state;
	}
	void method1() {
		state.executeAction1();
	}
	void method2() {
		state.executeAction2();
	}
}

interface State {
	void executeAction1();
	void executeAction2();
}

abstract class AbstractState implements State {
	protected Context context;
	public void setContext(Context context) {
		this.context = context;
	}
}

class ConcreteState1 extends AbstractState {
	@Override
	public void executeAction1() {
		System.out.println("executeAction1 in state1");
		context.changeState(new ConcreteState2());
	}
	@Override
	public void executeAction2() {
		System.out.println("executeAction2 in state1");
		context.changeState(new ConcreteState2());
	}
}

class ConcreteState2 extends AbstractState {
	@Override
	public void executeAction1() {
		System.out.println("executeAction1 in state2");
	}
	@Override
	public void executeAction2() {
		System.out.println("executeAction2 in state2");
		context.changeState(new ConcreteState1());
	}
}