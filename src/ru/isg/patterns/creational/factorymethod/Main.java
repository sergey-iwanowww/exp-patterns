package ru.isg.patterns.creational.factorymethod;

import java.util.Date;

/**
 * Created by s.ivanov on 04.09.2018.
 */
public class Main {
    public static void main(String[] args) {
        WatchProducer p = getWatchProducer("Rome");
        Watch w = p.createWatch();
        w.showTime();
    }

    private static WatchProducer getWatchProducer(String producer) {
        if (producer.equals("Digital")) {
            return new DigitalWatchProducer();
        } else if (producer.equals("Rome")) {
            return new RomeWatchProducer();
        } else {
            throw new IllegalArgumentException("Producer not supported: " + producer);
        }
    }
}

// Theory

// Producer's interface with a factory method
interface Creator {
    Product factoryMethod();
}

// Implementation of the producer's interface
class ConcreteCreator implements Creator {
    @Override
    public ConcreteProduct factoryMethod() {
        return new ConcreteProduct();
    }
}

// Product's interface
interface Product {
}

// Concrete product
class ConcreteProduct implements Product {
}

// Example
interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("Rome: " + new Date());
    }
}

interface WatchProducer {
    Watch createWatch();
}

class DigitalWatchProducer implements WatchProducer {
    @Override
    public DigitalWatch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchProducer implements WatchProducer {
    @Override
    public RomeWatch createWatch() {
        return new RomeWatch();
    }
}