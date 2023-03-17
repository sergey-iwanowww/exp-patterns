package ru.isg.patterns.behavioral.visitor;

/**
 * Created by s.ivanov on 25.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Element element1 = new ConcreteElement1();
		Element element2 = new ConcreteElement2();

		Visitor visitor1 = new ConcreteVisitor1();

		element1.accept(visitor1);
		element2.accept(visitor1);

		Visitor visitor2 = new ConcreteVisitor2();

		element1.accept(visitor2);
		element2.accept(visitor2);
	}
}

// Theory and example
interface Visitor {
	default void visit(ConcreteElement1 concreteElement1) {
		System.out.println("do nothing for concreteElement1");
	}
	default void visit(ConcreteElement2 concreteElement2) {
		System.out.println("do nothing for concreteElement2");
	}
}

class ConcreteVisitor1 implements Visitor {
	@Override
	public void visit(ConcreteElement1 concreteElement1) {
		System.out.println("visit by concreteVisitor1 concreteElement1");
	}
	@Override
	public void visit(ConcreteElement2 concreteElement2) {
		System.out.println("visit by concreteVisitor1 concreteElement2");
	}
}

class ConcreteVisitor2 implements Visitor {
	@Override
	public void visit(ConcreteElement2 concreteElement2) {
		System.out.println("visit by concreteVisitor2 concreteElement2");
	}
}

interface Element {
	void accept(Visitor visitor);
}

class ConcreteElement1 implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteElement2 implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}