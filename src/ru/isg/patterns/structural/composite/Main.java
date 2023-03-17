package ru.isg.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.ivanov on 09.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		ElementsBlock blockLevel0 = new ElementsBlock();
		blockLevel0.addComponent(new Circle());

		ElementsBlock blockLevel1 = new ElementsBlock();
		blockLevel1.addComponent(new Square());
		blockLevel1.addComponent(new Triangle());
		blockLevel0.addComponent(blockLevel1);

		blockLevel0.draw();
	}
}

// Theory

// Interface that declares method general method for composite and leaf objects
interface Component {
	void operation();
}

class Leaf implements Component {
	@Override
	public void operation() {
		System.out.println("leaf");
	}
}

class Composite implements Component {
	private List<Component> components = new ArrayList<>();
	@Override
	public void operation() {
		for (Component c : components) {
			c.operation();
		}
	}
	public void addComponent(Component c) {
		components.add(c);
	}
	public void removeComponent(Component c) {
		components.remove(c);
	}
}

// Example
interface Element {
	void draw();
}

class Circle implements Element {
	@Override
	public void draw() {
		System.out.println("circle");
	}
}

class Triangle implements Element {
	@Override
	public void draw() {
		System.out.println("triangle");
	}
}

class Square implements Element {
	@Override
	public void draw() {
		System.out.println("square");
	}
}

class ElementsBlock implements Element {

	private List<Element> elements = new ArrayList<>();

	public void addComponent(Element c) {
		elements.add(c);
	}

	public void removeElement(Element e) {
		elements.remove(e);
	}

	@Override
	public void draw() {
		for (Element e : elements) {
			e.draw();
		}
	}
}