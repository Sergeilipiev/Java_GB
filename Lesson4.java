import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
 * <p>
 * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 * <p>
 * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 * <p>
 * 3*. Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи. Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
 * Например:
 * 5 4 3 - + => 5 1 + => 6
 * Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
 */
public class Lesson4 {
    private static LinkedList<Integer> que = new LinkedList<Integer>();

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        LinkedList<Integer> lList = new LinkedList<Integer>();
        lList.add(1);
        lList.add(2);
        lList.add(3);
        LinkedList<Integer> lList2 = new LinkedList<Integer>();
        while (!lList.isEmpty()) {
            lList2.add(lList.pollLast());
        }
        System.out.println("lList2 = " + lList2);
    }

    public static void task2() {
//        LinkedList<Integer> que = new LinkedList<Integer>();
        enqueue(1);
        enqueue(2);
        enqueue(3);
        dequeue();
        System.out.println("que = " + que);
        System.out.println("first = " + first());
    }

    public static void enqueue(Integer i) {
        que.add(i);
    }

    public static void dequeue() {
        que.poll();
    }

    public static Integer first() {
        return que.getFirst();
    }

    public static void task3() {
        var exp = "5 4 3 - +".split(" "); // (1 + 2) * 3

        int res = 0;
        System.out.println(exp);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        res = st.pop() / st.pop();
                        st.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
