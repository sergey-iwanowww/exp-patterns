package ru.isg.pattern1delegate;

/**
 * Created by s.ivanov on 04.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		Painter p = new Painter();
		p.setGraphics(new Square());
		p.draw();
	}
}

// Теория

// делегируемый класс
class A {
	void f() {
		System.out.println("f()");
	}
}

// делегирующий класс
class B {
	A a = new A();

	void f() {
		a.f();
	}
}

// Пример

interface Graphics {
	void draw();
}

class Triangle implements Graphics {
	@Override
	public void draw() {
		System.out.println("Draw triangle");
	}
}

class Circle implements Graphics {
	@Override
	public void draw() {
		System.out.println("Draw circle");
	}
}

class Square implements Graphics {
	@Override
	public void draw() {
		System.out.println("Draw square");
	}
}

class Painter {
	Graphics graphics;
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	void draw() {
		graphics.draw();
	}
}