package ru.isg.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by s.ivanov on 28.09.2018.
 */
public class Main {
    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();

		List<Shape> shapes = IntStream.range(1, 8)
				.boxed()
				.map(i -> factory.getShape(i, i))
				.collect(Collectors.toList());

        for (Shape s : shapes) {
            s.draw();
        }
    }
}

// Theory and example

class Shape {

    int x;
    int y;
    SharedShapeData sharedData;

    public Shape(int x, int y, SharedShapeData sharedData) {
        this.x = x;
        this.y = y;
        this.sharedData = sharedData;
    }

    public void draw() {
        System.out.println(x + ", " + y + ": sharedData = " + sharedData);
    }
}

class SharedShapeData {
    byte[] bgImage;

    public SharedShapeData(byte[] bgImage) {
        this.bgImage = bgImage;
    }

    public byte[] getBgImage() {
        return bgImage;
    }
}

class ShapeFactory {

    private static final Map<String, SharedShapeData> sharedDatas = new HashMap<>();

    public static final String IMAGE_1010 = "image1010";
    public static final String IMAGE_2020 = "image2020";

    {
        sharedDatas.put(IMAGE_1010, new SharedShapeData(new byte[10 * 10]));
        sharedDatas.put(IMAGE_2020, new SharedShapeData(new byte[20 * 20]));
    }

    public Shape getShape(int x, int y) {
        int random = new Random().nextInt(2);
        return new Shape(x, y, random == 0 ? sharedDatas.get(IMAGE_1010) : sharedDatas.get(IMAGE_2020));
    }
}