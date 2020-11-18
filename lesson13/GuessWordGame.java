package lesson13;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GuessWordGame {

    static String[] words = {"яблоко", "апельсин", "лимон", "банан", "абрикос", "слива", "груша", "арбуз", "морковь", "чеснок", "виноград", "дыня", "лук", "киви", "манго", "поганка", "орех", "сыроежка", "капуста", "картошка", "персик", "перец", "ананас", "смородина", "клубника"};
    static int index;
    static int currentLetter = 0;
    static final int MASK_LEN = 15;

    public static void main(String[] args) throws IOException {

        newGame();

    }

    private static void newGame() throws IOException {
        boolean gameIsOn = true;
        String answer;
        Random rnd = new Random();

        index = rnd.nextInt(words.length - 1);
        System.out.println("Подсказка: " + words[index] + "\n");
        System.out.println("Итак, я загадал некое слово. Прошу начать его отгадывать (по-русски)");

        do {
            answer = getAnswer();
            if(compareAnswer(answer)) {
                System.out.println("Нехило играешь! Молодец!");
                gameIsOn = false;
            } else {
                showCorrectLetters(answer);
            }
        } while (gameIsOn);
    }

    private static void showCorrectLetters(String answer) {
        int len = Math.min(answer.length(), words[index].length());

        for (int i = 0; i < len; i++) {                             //проверяем буквы на совпадения
            if (answer.charAt(i) == words[index].charAt(i))
                System.out.print(answer.charAt(i));
            else
                System.out.print("#");
        }

        for (int i = 0; i < (MASK_LEN - len); i++) {                //добиваем символами #
            System.out.print("#");
        }
        System.out.println();
    }

    private static boolean compareAnswer(String answer) {
        if(words[index].equals(answer))                         //если выиграли, возвращаем true
            return true;

        return false;
    }

    private static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
