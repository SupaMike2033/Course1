package lesson12;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        myArray1();
        myArray2();
        myArray3();
        myArray4();
        myArray5();

        System.out.println("\nЗадание №6");
        int[] arr = {1, 2, 10, 3, 0, 8, 15, 7, 2};              // есть баланс
        printBalanceResult(checkBalance(arr));

        int[] arr2 = {2, 2, 2, 1, 1, 2, 2, 2, 2};                // есть баланс
        printBalanceResult(checkBalance(arr2));

        int[] arr3 = {2,3,4,54,65,78,3,2,5,78,9,0,7,45,3};      // нет баланса
        printBalanceResult(checkBalance(arr3));

        System.out.println("\nЗадание №7");
        shiftArray(arr, 2);
        shiftArray(arr, -3);
        arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        shiftArray(arr2, 2);
        shiftArray(arr2, -5);

    }

    private static void shiftArray(int[] arr, int x) {
        System.out.println("Сдвиг = " + x);
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int tmp;
        if(x > 0) {                                             // сдвигаем вправо
            for (int i = 0; i < x; i++) {
                tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        }
        else if(x < 0) {                                        // сдвигаем влево
            for (int i = 0; i < -x; i++) {
                tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }

        System.out.println("Двинутый массив: " + Arrays.toString(arr));
        System.out.println();
    }

    private static boolean checkBalance(int[] arr) {
        int sum = 0, balanceSum = 0, position = 0;

        for (int i = 0; i < arr.length; i++) {                  // вычисляем сумму всех эл. массива
            sum += arr[i];
        }

        for (int i = arr.length - 1; i > -1 ; i--) {            // идём справа налево
            balanceSum += arr[i];
            if(balanceSum == (sum / 2)) {                       // точка баланса - на этой позиции
                position = i;
                break;
            }
        }
        if(position == 0) {
            System.out.print("Баланс не найден");
            return false;
        }

        System.out.print("Баланс между позиций " + position + " и " + (position + 1) + ": ");
        for (int i = 0; i < arr.length; i++) {
            if (i == position)
                System.out.print("| ");

            System.out.print(arr[i] + " ");
        }
//        System.out.println();
        return true;
    }

    private static void myArray5() {
        System.out.println("\nЗадание №5");
        int[] arr = new int[20];
        Random rnd = new Random();
        int min = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
        }

        min = arr[0];
        max = min;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("MIN = " + min + "\nMAX = " + max);
    }

    public static void myArray4() {
        System.out.println("\nЗадание №4");
        int[][] arr = new int[9][9];
        int arrRows = arr.length;
        int arrColumns = arr[0].length;
        System.out.println("Массив размером [" + arrRows + "][" + arrColumns + "]");
        for (int i = 0; i < arrRows; i++) {
            for (int j = 0; j < arrColumns; j++) {
                if(j == i)
                    arr[i][j] = 1;
            }
            arr[i][arrColumns - i - 1] = 1;
        }

        for (int i = 0; i < arrRows; i++) {
            for (int j = 0; j < arrColumns; j++) {
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void myArray3() {
        System.out.println("\nЗадание №3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6)
                arr[i] *= 2;
        }
        System.out.println("Конечный массив: " + Arrays.toString(arr));
    }

    public static void myArray2() {
        System.out.println("\nЗадание №2");
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void myArray1() {
        System.out.println("Задание №1");
        // в качестве "случайности" заполнения берётся число в двоичном формате (задом наперёд)
        Random rnd = new Random();
        int x = rnd.nextInt(Integer.MAX_VALUE);
        int boolArrLen =  Integer.toBinaryString(x).length();   // длина массива
        int[] boolArr = new int[boolArrLen];
        System.out.println("X = " + x + ", длина = " + boolArrLen);

        for (int i = 0; i < boolArrLen; i++) {                  // заполняем массив случайными цифрами 0 или 1
            if( (x % 2) != 0)
                boolArr[i] = 1;
            else
                boolArr[i] = 0;
            x /= 2;
        }

        System.out.println("Исходный массив:        " + Arrays.toString(boolArr));

        for (int i = 0; i < boolArrLen; i++) {
            if(boolArr[i] == 1)
                boolArr[i] = 0;
            else
                boolArr[i] = 1;
        }

        System.out.println("Инвертированный массив: " + Arrays.toString(boolArr));
    }
    private static void printBalanceResult(boolean ifIs) {
        if (ifIs)
            System.out.println(" - есть баланс.");
        else
            System.out.println(" - не сфортило.");
    }
}
