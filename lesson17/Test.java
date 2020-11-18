package lesson17;

import lesson16.Const;

import java.util.Random;

public class Test {

    private static final int APPETIT_LIMIT = 10;            // макс. сколько кошка может съесть
    private static final int PLATE_LIMIT = 10;              // объём миски
    static Random rnd = new Random();

    public static void main(String[] args) {

        Cat cat = new Cat(Const.generateCatName(), rnd.nextInt(APPETIT_LIMIT-1)+1);
        Plate plate = new Plate(PLATE_LIMIT);

        plate.addFood(rnd.nextInt(PLATE_LIMIT));
        plate.printInfo();
        cat.eat(plate);
        plate.printInfo();


    }
}