package lesson13;

import java.util.Random;
import java.util.Scanner;

public class GuesNumberGame {

    static int randomNumber;
    static int tryCount = 1, maxTries = 3;
    static final int MIN = 0;
    static final int MAX = 10;

    public static void main(String[] args) {

        while (newGame()) {}

    }

    private static boolean newGame() {
        boolean gameOver = false;

        Random rnd = new Random();
        randomNumber = rnd.nextInt(MAX);
        System.out.println("Загадал " + randomNumber + "\n");   // это - подсказка, без неё сложно :)

        System.out.println("Ну чё, я загадал число от 0 до 10 включительно. \nПопробуй угадать.");
        while (requestInput()) {}

        if(tryCount == (maxTries + 1))
            System.out.println("Вы проиграли :( Я загадал " + randomNumber);
        else
            System.out.println("Поздравляю! Выиграли!");

        return askForPlayAgain();
    }


    private static boolean requestInput() {
        int answer = 0;

        System.out.print("Попытка № " + tryCount + ": ");

        answer = getNumberFromScanner();

        if(answer == randomNumber)                      // если угадали, возвращаем false
            return false;

        if(++tryCount == (maxTries + 1))                // если закончились попытки, возвращаем false
            return false;

        compareAnswerWithNumber(answer);

        return true;                                    // если НЕ угадали, возвращаем true
    }

    private static void compareAnswerWithNumber(int answer) {
        if(answer > randomNumber)
            System.out.println("Загаданное мною число чуть МЕНЬШЕ");
        else
            System.out.println("Я загадал БОЛЬШЕЕ число");
    }

    private static int getNumberFromScanner() {
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            answer = scanner.nextInt();
        } while (!checkIfInBounds(answer));

        return answer;
    }

    private static boolean checkIfInBounds(int answer) {
        if((answer < MIN) || (answer > MAX)) {
            System.out.println("Э! Э! Э! Введите число в рамках наших границ: " + MIN + "-" + MAX);
            return false;
        }

        return true;
    }

    private static boolean askForPlayAgain() {
        int answer;
        System.out.print("\nХотите ещё разок сыграть? 1-Да, играем. 0 - Нет, я зассал: ");
        answer = getNumberFromScanner();

        switch (answer) {
            case (0):
                System.out.println("Format c:");    // не смог удержаться :)
                return false;
            default:
                for (int i = 0; i < 10; i++) {      // очищаем консоль
                    System.out.println();
                }
                return true;                        // всё, что не 0 = хотим играть
        }
    }
}

