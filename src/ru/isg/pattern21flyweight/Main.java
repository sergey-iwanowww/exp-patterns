package ru.isg.pattern21flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by s.ivanov on 28.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		ShapeFactory factory = new ShapeFactory();

		List<Shape> shapes = new ArrayList<>();
		shapes.add(factory.getShape("точка"));
		shapes.add(factory.getShape("квадрат"));
		shapes.add(factory.getShape("круг"));
		shapes.add(factory.getShape("квадрат"));
		shapes.add(factory.getShape("точка"));
		shapes.add(factory.getShape("квадрат"));

		for (Shape s : shapes) {
			Random r = new Random();
			// координаты - внешнее состояние, уникальное, изменяемое
			// форма фигуры и ее поля - внутреннее состояние
			s.draw(r.nextInt(), r.nextInt());
		}
	}
}

interface Shape {
	void draw(int x, int y);
}

class Point implements Shape {
	@Override
	public void draw(int x, int y) {
		System.out.println(x + ", " + y + ": точка");
	}
}

class Circle implements Shape {
	int r = 5;
	@Override
	public void draw(int x, int y) {
		System.out.println(x + ", " + y + ": круг с радиусом = " + r);
	}
}

class Square implements Shape {
	int a = 10;
	@Override
	public void draw(int x, int y) {
		System.out.println(x + ", " + y + ": квадрат со стороной = " + a);
	}
}

class ShapeFactory {
	private static final Map<String, Shape> shapes = new HashMap<>();
	public Shape getShape(String name) {
		Shape shape = shapes.get(name);
		if (shape != null) {
			return shape;
		}
		if (name.equals("точка")) {
			shape = new Point();
		}
		else if (name.equals("круг")) {
			shape = new Circle();
		}
		else if (name.equals("квадрат")) {
			shape = new Square();
		}
		shapes.put(name, shape);
		return shape;
	}
}