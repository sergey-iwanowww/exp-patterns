package ru.isg.patterns.structural.proxy;

/**
 * Created by s.ivanov on 27.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		// Force image uploading even if client didn't want to view image
		 Image image = new RealImage("D:\\force1.png");

		 image = new RealImage("D:\\force2.png");
		 image.display();

		// Lazy image uploading only if client is viewing image
		image = new ProxyImage("D:\\lazy1.png");

		image = new ProxyImage("D:\\lazy2.png");
		image.display();
	}
}

// Theory and example

interface Image {
	void display();
}

class RealImage implements Image {

	private String file;

	public RealImage(String file) {
		this.file = file;
		load();
	}

	void load() {
		System.out.println("Загрузка файла " + file);
	}

	@Override
	public void display() {
		System.out.println("Просмотр файла " + file);
	}
}

// Proxy for lazy init
class ProxyImage implements Image {

	private String file;
	private RealImage realImage;

	public ProxyImage(String file) {
		this.file = file;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(file);
		}
		realImage.display();
	}
}