package ru.isg.pattern18visitor;

/**
 * Created by s.ivanov on 25.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Element element1 = new ConcreteElement1();
		Element element2 = new ConcreteElement2();

		Visitor visitor = new ConcreteVisitor();

		element1.accept(visitor);
		element2.accept(visitor);
	}
}

interface Visitor {
	void visit(ConcreteElement1 concreteElement1);
	void visit(ConcreteElement2 concreteElement2);
}

class ConcreteVisitor implements Visitor {
	@Override
	public void visit(ConcreteElement1 concreteElement1) {
		System.out.println("visit concrete element 1");
	}
	@Override
	public void visit(ConcreteElement2 concreteElement2) {
		System.out.println("visit concrete element 2");
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