package lesson21;

import java.util.Random;

public class Main {

    static Random rnd = new Random();
    static Object[] racers = new Object[Const.QUANTITY_OF_PARTICIPANTS];
    static Barrier[] barriers = new Barrier[Const.QUANTITY_OF_CYCLES];
    static RaceTrack[] raceTracks = new RaceTrack[Const.QUANTITY_OF_CYCLES];
    static Human[] men;
    static Pussy[] cats;
    static Robot[] robots;

    public static void main(String[] args) {
        generateStartList(generateParticipants());      // создаём список спортсменов
        generateTrials();                               // создаём дорожки и барьеры
        startRace();                                    // начинаем и тут же заканчиваем соревнования
    }

    private static void generateStartList(int i) {      // приходит значение типа 241 (2 робота, 4 кошки, 1 человек)
        generateHumans(i % 10);
        i /= 10;
        generatePussies(i % 10);
        i /= 10;
        if (i > 0)
            generateRobots(i);
    }

    private static void generateTrials() {
        for (int i = 0; i < Const.QUANTITY_OF_CYCLES; i++) {
            System.out.println("Этап № " + (i + 1));

            barriers[i] = new Barrier();
            barriers[i].setHeight(rnd.nextInt(Const.BARRIER_MAX_HEIGHT) + 1);
            barriers[i].Info();

            raceTracks[i] = new RaceTrack();
            raceTracks[i].setLenght(rnd.nextInt(Const.TRACK_MAX_LENGTH) + 1);
            raceTracks[i].Info();
        }
    }

    private static void startRace() {
        for (int i = 0; i < Const.QUANTITY_OF_CYCLES; i++) {
            System.out.println("\n\nФинальное табло этапа № " + (i+1) + ":\n===================================");

            for (Object racer : racers) {
                if (racer instanceof Human) {
                    System.out.println(((Human) racer).getName() + " (человек)\n-----------------------------------");
                } else if (racer instanceof Pussy) {
                    System.out.println(((Pussy) racer).getName() + " (кошка)\n-----------------------------------");
                } else {
                    System.out.println(((Robot) racer).getName() + " (робот)\n-----------------------------------");
                }

                System.out.println("Результат забега: " + raceTracks[i].isOvercome(racer));
                System.out.println("Результат барьера: " + barriers[i].isOvercome(racer) + "\n");
            }
        }
    }

    private static void generateRobots(int i) {
        System.out.println("Robots = " + i);
        if (i == 0) return;
        robots = new Robot[i];
        int pos = 0;
        for (int j = 0; j < racers.length; j++) {
            if (racers[j] == null) {
                pos = j;
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            robots[j] = new Robot();
            robots[j].setName(Const.generateRobotName());
            robots[j].setDistance(rnd.nextInt(Const.TRACK_MAX_LENGTH) + 1);
            robots[j].setHeight(rnd.nextInt(Const.BARRIER_MAX_HEIGHT) + 1);
            robots[j].Info();
            racers[pos + j] = robots[j];
        }
    }

    private static void generatePussies(int i) {
        if (i == 0)
            return;
        System.out.println("Pussies = " + i);
        cats = new Pussy[i];
        int pos = 0;
        for (int j = 0; j < racers.length; j++) {
            if (racers[j] == null) {
                pos = j;
                break;
            }
        }

        for (int j = 0; j < i; j++) {
            cats[j] = new Pussy();
            cats[j].setName(Const.generateCatName());
            cats[j].setDistance(rnd.nextInt(Const.TRACK_MAX_LENGTH) + 1);
            cats[j].setHeight(rnd.nextInt(Const.BARRIER_MAX_HEIGHT) + 1);
            cats[j].Info();
            racers[pos + j] = cats[j];
        }
    }

    private static void generateHumans(int i) {
        System.out.println("Humans = " + i);
        men = new Human[i];
        for (int j = 0; j < i; j++) {
            men[j] = new Human();
            men[j].setName(Const.generateHumanName());
            men[j].setDistance(rnd.nextInt(Const.TRACK_MAX_LENGTH) + 1);
            men[j].setHeight(rnd.nextInt(Const.BARRIER_MAX_HEIGHT) + 1);
            men[j].Info();
            racers[j] = men[j];
        }
    }

    // возвращает список участников: РКЧ (в сотнях = роботы, в десятках = кошки, в единицах = люди)
    private static int generateParticipants() {
        if (Const.QUANTITY_OF_PARTICIPANTS == 1)
            return 1;               // если выбран только 1 участник, то пусть он будет человеком
        int tmp_counter = Const.QUANTITY_OF_PARTICIPANTS;

        int tmp_rnd = rnd.nextInt(tmp_counter / 2) + 1;
        int i = tmp_rnd;            // сгенерили кол-вол людей
        tmp_counter -= tmp_rnd;
        if (tmp_counter <= 0) return i;

        tmp_rnd = rnd.nextInt(tmp_counter) + 1;
        tmp_counter = i + tmp_rnd;
        i += tmp_rnd * 10;
        i += (Const.QUANTITY_OF_PARTICIPANTS - tmp_counter) * 100;

        return i;
    }
}
