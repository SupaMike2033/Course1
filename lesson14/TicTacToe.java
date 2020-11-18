package lesson14;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 5;                  // размер поля (оно квадратное)
    static final int DOTS_TO_WIN = 4;           // сколько надо выстроить в ряд для победы


    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final String HEADER_FIRST_EMPTY = " ";
    static final String EMPTY = " ";


    static char[][] map = new char[SIZE][SIZE];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapRow();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);


            aiTurn();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        int tmp;
        // решил ввод коорд. делать двузначным числом сразу - так легче
        System.out.println("\nХод человека! Введите номер строки и столбца (напр. '32'): ");
        do {
            //System.out.print("Строка = ");
            tmp = scanner.nextInt();
            //rowNumber = scanner.nextInt();
            rowNumber = tmp % 10;
            //System.out.print("Столбец = ");
            //colNumber = scanner.nextInt();
            colNumber = tmp / 10;
            System.out.println("Столб = " + colNumber + ", cтрока = " + rowNumber);
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNumber, int colNumber, boolean isAI) {

        if (!isAI && ((rowNumber < 1) || (rowNumber > SIZE) || (colNumber < 1) || (colNumber > SIZE))) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if (!isAI) {
                System.out.println("\nВы выбрали занятую ячейку");
            }
            return false;
        }

        return true;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        return isCellValid(rowNumber, colNumber, false);
    }

    private static void checkEnd(char symbol) {

        boolean isEnd = false;

        if(checkWin(symbol)) {
            String winMessage;

            if(symbol == DOT_HUMAN) {
                winMessage = "УРА! Вы победили!";
            }
            else {
                winMessage = "Восстание близко! AI победил";
            }

            isEnd = true;
            System.out.println(winMessage);
        }

        if(!isEnd && isMapFull()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if(isEnd) {
            System.exit(0);
        }
    }

    // если победа, возвращает true, иначе - ХЗ
    // смысл моей проверки:
    // сначала сканируем все столбцы, потом - все строки, потом - все главные диагонали, потом - все восходящие диагонали
    // ищем 3 подряд символа Х или О
    private static boolean checkWin(char symbol) {
        return (checkCols(symbol) || checkRows(symbol) || checkMainDiag(symbol) || checkBackDiag(symbol));
    }

    private static boolean checkCols(char symbol) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {        // пробегаемся по всем колонкам
            counter = 1;                        // т.к. первый подсчёт будет, когда будет пара, начинаем с "1"
            for (int j = 1; j < SIZE; j++) {
                if((map[j][i] == symbol) && (map[j - 1][i] == symbol)){ // если крестики расположены подряд, считаем их
                    counter++;
                    //System.out.println("CounterC = " + counter);
                    if(counter == DOTS_TO_WIN)
                        return true;
                }
                else {
                    counter = 1;
                }
            }
        }
        return false;
    }

    private static boolean checkRows(char symbol) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {        // пробегаемся по всем колонкам
            counter = 1;                        // т.к. первый подсчёт будет, когда будет пара, начинаем с "1"
            for (int j = 1; j < SIZE; j++) {
                if((map[i][j] == symbol) && (map[i][j - 1] == symbol)){ // если крестики расположены подряд, считаем их
                    counter++;
                    //System.out.println("CounterR = " + counter);
                    if(counter == DOTS_TO_WIN)
                        return true;
                }
                else {
                    counter = 1;
                }
            }
        }
        return false;
    }

    private static boolean checkMainDiag(char symbol) {
        int counter1 = 1, counter2 = 1;
        for (int i = 0; i <= (SIZE - DOTS_TO_WIN); i++) {
            for (int j = 1; j < (SIZE - i); j++) {
                if(map[i + j][j] == symbol && (map[i + j - 1][j - 1]) == symbol) {
                    counter1++;
                    //System.out.println("Counter1 = " + counter1);
                    if(counter1 == DOTS_TO_WIN)
                        return true;
                } else {
                    counter1 = 1;
                }

                if(map[j][i + j] == symbol && map[j - 1][i + j - 1] == symbol) {
                    counter2++;
                    //System.out.println("Counter2 = " + counter2);
                    if(counter2 == DOTS_TO_WIN)
                        return true;
                } else {
                    counter2 = 1;
                }
            }
        }
        return false;
    }

    private static boolean checkBackDiag(char symbol) {
        int x = 0, y;
        int counter;

        for (int i = 0; i <= ((SIZE - DOTS_TO_WIN) * 2 + 1); i++) {
            if(i < (SIZE - DOTS_TO_WIN + 1)) {
                counter = 1;
                x = 0;
                for (y = i + DOTS_TO_WIN - 1; y > 0; y--) {
                    if((map[x][y] == symbol) && map[x + 1][y - 1] == symbol) {
                        counter++;
                        //System.out.println("CounterBD = " + counter);
                        if(counter == DOTS_TO_WIN)
                            return true;
                    }
                    x++;
                }
            } else {
                counter = 1;
                x = i - SIZE + DOTS_TO_WIN;
                for (y = SIZE - 1; x < SIZE - 1; y--) {
                    if((map[x][y] == symbol) && map[x + 1][y - 1] == symbol) {
                        counter++;
                        //System.out.println("CounterBD = " + counter);
                        if(counter == DOTS_TO_WIN)
                            return true;
                    }
                    x++;
                }
            }
        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if(aChar == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        System.out.println("\nХод компьютера!\n");
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, true));

        map[rowNumber - 1][colNumber - 1] = DOT_AI;
    }

}