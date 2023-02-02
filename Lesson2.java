//1. В файле содержится строка с исходными данными в такой форме:
//{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
//SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
//Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.

//2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

//3. В файле содержится строка с данными:
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Lesson2 {
    private static String sql;
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
    }

    private static void task1() throws IOException {
        String fileStr = readFile("src/2_1.txt");
        String[] strArr = fileStr.split(", ");
        for (String name : strArr) {
            String str = clear(name, new String[]{"{","}","\""});
            addToSqlStr(str);
        }
        System.out.println(sql);
    }

    private static void task2() throws IOException {
        int[] sortArr = {4, 7, 8, 23, 1, 65};
        bubbleSort(sortArr);
        for (int j : sortArr) {
            System.out.print(j + "\n");
        }
    }
    private static void task3() throws IOException {
        String fileStr = readFile("src/2_3.txt");
        fileStr = clear(fileStr, new String[]{"[","]"});
        String[] strArr = fileStr.split(", ");
        for (String name : strArr) {
            String str = clear(name, new String[]{"{","}","\""});
            String[] strArr2 = str.split(",");
            StringBuilder finalStr = new StringBuilder();
            for (String name2 : strArr2) {
                String[] strArr3 = name2.split(":");
                if (Objects.equals(strArr3[0], "фамилия")) finalStr.append("Студент ").append(strArr3[1]);
                if (Objects.equals(strArr3[0], "оценка")) finalStr.append(" получил ").append(strArr3[1]);
                if (Objects.equals(strArr3[0], "предмет")) finalStr.append(" по предмету ").append(strArr3[1]).append(".");
            }
            System.out.println(finalStr);
        }
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void addToSqlStr(String str) {
        String[] newStr = str.split(":");
        if (sql == null) sql = "SELECT * FROM students WHERE " + newStr[0] + " = \"" + newStr[1] + "\"";
        else if (!Objects.equals(newStr[1], "null")) {
            sql += " AND " + newStr[0] + " = \"" + newStr[1] + "\"";
        }
    }

    public static String clear(String str, String[] ch) {
        for (String c : ch) {
            str = str.replace(c, "");
        }
        return str;
    }

    public static void bubbleSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
}
