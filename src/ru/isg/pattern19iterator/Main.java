package ru.isg.pattern19iterator;

/**
 * Created by s.ivanov on 27.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		MyAggregate ma = new MyConcreteAggregate("Hello", ",", "my", "baby");

		MyIterator mi = ma.getIterator();

		System.out.println(mi.next());
		System.out.println(mi.next());
		System.out.println(mi.next());
		System.out.println(mi.next());
		System.out.println(mi.next());
		System.out.println(mi.next());
		System.out.println(mi.next());
	}
}

// Теория
interface Iterator {
	Element next();
	boolean hasNext();
}

class ConcreteIterator implements Iterator {

	ConcreteAggregate aggregate;

	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public Element next() {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}
}

interface Aggregate {
	Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {
	@Override
	public Iterator getIterator() {
		return new ConcreteIterator(this);
	}
}

abstract class Element {

}

// Пример
interface MyIterator {
	String next();
	boolean hasNext();
}

interface MyAggregate {
	MyIterator getIterator();
}

class MyConcreteAggregate implements MyAggregate {

	private String[] array;

	public MyConcreteAggregate(String... array) {
		this.array = array;
	}

	@Override
	public MyIterator getIterator() {
		return new MyConcreteIterator();
	}

	private class MyConcreteIterator implements MyIterator {

		private int index = 0;

		@Override
		public String next() {
			if (hasNext()) {
				String result = array[index];
				index++;
				return result;
			}
			else {
				return null;
			}
		}

		@Override
		public boolean hasNext() {
			return index < array.length;
		}
	}
}

