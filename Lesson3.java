import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Урок 3. Коллекции JAVA: Введение
//1. Реализовать алгоритм сортировки слиянием.
//2. Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
//3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
//4*. (Необязательная задача повышенной сложности)
//Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
//Разность:
//A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
//B - A = все числа из второй коллекции, которые не содержатся в первой
//Симметрическая разность:
//A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
public class Lesson3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        int[] numbers = { 3, 23, 7, 11, 5, 2, 6, 9, 25, 17, 4 };
        System.out.println(Arrays.toString(mergeSort(numbers)));

    }
    private static void task2() {
        ArrayList<Integer> list = randomIntList(0,30);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
    private static void task3() {
        ArrayList<Integer> list = randomIntList(2,30);
        System.out.println(list);
        int min = 0; int max = 0; double mid = 0;
        int len = list.size(); int sum = 0;
        for (Integer num: list) {
            sum+=num;
            if (num > max) max = num;
        }
        min = max;
        for (Integer num: list) if (num < min) min = num;

        mid = (double)sum / (double)len;
        System.out.printf("Минимальное число - %s\n", min);
        System.out.printf("Максимальное число - %s\n", max);
        System.out.printf("Среднее арифмитическое - %s\n", mid);
    }

    public static int[] mergeSort(int[] src) {
        if (src.length <= 1) return src;
        int[] left = Arrays.copyOfRange(src, 0, src.length / 2);
        int[] right = Arrays.copyOfRange(src, left.length, src.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int resIn = 0, leftIn = 0, rightIn = 0;
        int[] result = new int[left.length + right.length];

        while (leftIn < left.length && rightIn < right.length)
            if (left[leftIn] < right[rightIn])
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        while (resIn < result.length)
            if (leftIn != left.length)
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        return result;
    }
    public static int random (Integer from, Integer to) {
        Random random = new Random();
        return random.nextInt(from,to);
    }
    public static ArrayList<Integer> randomIntList (Integer from, Integer to) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random(2,30); i++) list.add(random.nextInt(from,to));
        return list;
    }
}
