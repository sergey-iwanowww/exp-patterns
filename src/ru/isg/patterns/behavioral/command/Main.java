package ru.isg.patterns.behavioral.command;

/**
 * Created by s.ivanov on 11.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Comp comp = new Comp();
		User u = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
		u.startComp();
		u.stopComp();
		u.resetComp();
	}
}

// Theory and example

// Command's interface
interface Command {
	void execute();
}

// Concrete commands
class StartCommand implements Command {
	Comp comp;

	public StartCommand(Comp comp) {
		this.comp = comp;
	}

	@Override
	public void execute() {
		comp.start();
	}
}

class StopCommand implements Command {
	Comp comp;

	public StopCommand(Comp comp) {
		this.comp = comp;
	}

	@Override
	public void execute() {
		comp.stop();
	}
}

class ResetCommand implements Command {
	Comp comp;

	public ResetCommand(Comp comp) {
		this.comp = comp;
	}

	@Override
	public void execute() {
		comp.reset();
	}
}

// Receiver
class Comp {
	void start() {
		System.out.println("start");
	}

	void stop() {
		System.out.println("stop");
	}

	void reset() {
		System.out.println("reset");
	}
}

// Invoker
class User {
	private Command start;
	private Command stop;
	private Command reset;

	public User(Command start, Command stop, Command reset) {
		this.start = start;
		this.stop = stop;
		this.reset = reset;
	}

	void startComp() {
		start.execute();
	}

	void stopComp() {
		stop.execute();
	}

	void resetComp() {
		reset.execute();
	}
}