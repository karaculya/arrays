import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static int[] completionArray(int n) {
        int[] a = new int[n];

        for(int i = 0; i < n; ++i) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }

        return a;
    }

    public static int countMaxValue(int[] a) {
        int maxNum = a[0];
        int[] var2 = a;
        int var3 = a.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int j = var2[var4];
            if (j > maxNum) {
                maxNum = j;
            }
        }

        return maxNum;
    }

    public static int countMinValue(int[] a) {
        int minNum = a[0];
        int[] var2 = a;
        int var3 = a.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int k = var2[var4];
            if (k < minNum) {
                minNum = k;
            }
        }

        return minNum;
    }

    public static int countAverageValue(int[] a) {
        int averageValue = 0;

        for(int i = 0; i < a.length; ++i) {
            averageValue += a[i];
        }

        averageValue /= a.length;
        return averageValue;
    }

    public static void sortArray(int[] a) {
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for(int i = 0; i < a.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    isSorted = false;
                    int buf = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = buf;
                }
            }
        }

    }

    public static int[] deleteArrayElement(int[] a, int index) {
        for(int i = index; i < a.length - 1; ++i) {
            a[i] = a[i + 1];
        }

        int[] temp = new int[a.length];

        int i;
        for(i = 0; i < a.length; ++i) {
            temp[i] = a[i];
        }

        a = new int[a.length - 1];

        for(i = 0; i < a.length; ++i) {
            a[i] = temp[i];
        }

        return a;
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = null;
        System.out.println("1-создать массив\r\n" +
                "2-посчитать его основные значения\r\n" +
                "3-отсортировать массив\r\n" +
                "4-удалить элемент массива\r\n" +
                "5-вывести получившийся массив\r\n" +
                "6-выход");
        int n = 0;

        while(n !=6) {
            n = input.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Введите размер массива:");
                    int n1 = input.nextInt();
                    a = completionArray(n1);
                    System.out.println("Массив заполнен");
                    System.out.println(Arrays.toString(a));
                    break;
                case 2:
                    int maxNum = countMaxValue(a);
                    System.out.println("Максимальное значение массива = " + maxNum);
                    int minNum = countMinValue(a);
                    System.out.println("Минимальное значение массива =" + minNum);
                    int averageValue = countAverageValue(a);
                    System.out.println("Среднее значение массива =" + averageValue);
                    break;
                case 3:
                    sortArray(a);
                    System.out.println(Arrays.toString(a));
                    break;
                case 4:
                    System.out.println("Введите индекс элемента массива для удаления:");
                    int index = input.nextInt();
                    a = deleteArrayElement(a, index);
                    System.out.println("Получившийся массив: " + Arrays.toString(a));
                    break;
                case 5:
                    System.out.print("Элементы масиива:");
                    printArray(a);
                    break;
                case 6:
                    return;
            }
        }

    }
}