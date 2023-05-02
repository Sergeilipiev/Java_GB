package Lesson6;

import java.util.*;

public class NotebookStorage {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>(Arrays.asList(
                new Notebook("Model1", 8, 256, "Windows", "Black"),
                new Notebook("Model2", 16, 512, "MacOS", "Silver"),
                new Notebook("Model3", 16, 1024, "Linux", "White")
        ));

        Map<String, Integer> criteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет");

        int choice = scanner.nextInt();
        System.out.println("Введите минимальное значение для выбранного критерия:");
        int minValue = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                criteria.put("ram", minValue);
                break;
            case 2:
                criteria.put("storage", minValue);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                criteria.put("os", os.hashCode());
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                criteria.put("color", color.hashCode());
                break;
            default:
                System.out.println("Некорректный выбор");
                return;
        }

        NotebookFilter filter = new NotebookFilter();
        List<Notebook> filteredNotebooks = filter.filterNotebooks(notebooks, criteria);
        System.out.println("Отфильтрованные ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}