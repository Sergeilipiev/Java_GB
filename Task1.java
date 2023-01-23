//Написать программу вычисления n-ого треугольного числа

public class Task1 {
    public static void main(String[] args) {
        int a = Library.getNumberByUser("Введите число : ");
        System.out.println("Треугольное число = " + triangle(a));
    }

    /**
     * Метод вычисляет треугольное число
     *
     * @param num Число
     * @return Треугольное число
     */
    public static int triangle(int num) {
        if (num == 1) {
            return 1;
        }
        return triangle(num - 1) + num;
    }
}