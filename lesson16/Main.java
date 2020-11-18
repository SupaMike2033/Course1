package lesson16;

import java.util.Random;

public class Main {

    private static final int DOG_FLOCK = 5;         // размер стаи собак
    private static final int CAT_FLOCK = 5;         // размер стаи кошек
    private static final int FLUCT_COEF = 2;        // коэфф. разброса генератора (чем больше, тем меньше попаданий в пределы)

    static Random rnd = new Random();
    static Dog[] dogs = new Dog[DOG_FLOCK];
    static Cat[] cats = new Cat[CAT_FLOCK];

    public static void main(String[] args) {
        runGame();
    }

    private static void runGame() {
        
        fillDogs();

        fillCats();

        printDogs();

        printCats();

    }

    private static void fillCats() {
        for (int i = 0; i < CAT_FLOCK; i++) {
            cats[i] = new Cat();
            cats[i].setName(Const.generateCatName());
            cats[i].setDistRun(rnd.nextInt(Const.CAT_MAX_RUN * FLUCT_COEF));
            cats[i].setDistSwim(-1);                                    // кошки не умеют плавать
            cats[i].setDistJump((float) (Math.round((rnd.nextFloat() * Const.CAT_MAX_JUMP * FLUCT_COEF) * 100))/100);
        }
    }

    private static void fillDogs() {
        for (int i = 0; i < DOG_FLOCK; i++) {
            dogs[i] = new Dog();
            dogs[i].setName(Const.generateDogName());
            dogs[i].setDistRun(rnd.nextInt(Const.DOG_MAX_RUN * FLUCT_COEF));
            dogs[i].setDistSwim(rnd.nextInt(Const.DOG_MAX_SWIM * FLUCT_COEF));
            dogs[i].setDistJump((float) (Math.round((rnd.nextFloat() * Const.DOG_MAX_JUMP * FLUCT_COEF) * 100))/100);
        }
    }

    private static void printDogs() {
        for (int i = 0; i < DOG_FLOCK; i++) {
            dogs[i].printDogInfo();
            dogs[i].toRun();
            dogs[i].toJump();
            dogs[i].toSwim();
            System.out.println();
        }
    }

    private static void printCats() {
        for (int i = 0; i < CAT_FLOCK; i++) {
            cats[i].printCatInfo();
            cats[i].toRun();
            cats[i].toJump();
            cats[i].toSwim();
            System.out.println();
        }
    }
}
