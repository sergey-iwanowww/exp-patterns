package ru.isg.pattern20proxy;

/**
 * Created by s.ivanov on 27.09.2018.
 */
public class Main {
	public static void main(String[] args) {

		// Загружает картинку, даже если клиент не собирался ее просматривать
		// Image image = new RealImage("D:\\file.png");
		// image.display();

		// Загружает картинку только если клиент решил просмотреть картинку
		Image image = new ProxyImage("D:\\file.png");
		image.display();
	}
}

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