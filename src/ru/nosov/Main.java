package ru.nosov;

import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Task1:");
        /*1 Написать метод, который на входе получает коллекцию объектов,
         *а возвращает коллекцию уже без дубликатов.
         *Для решения этой задачи пригодится Set.
         */
        ArrayList<String> numbers = new ArrayList<>() ;
        numbers.add("Add");
        numbers.add("some");
        numbers.add("test");
        numbers.add("test");
        numbers.add("elements");

        System.out.println("Collection with duplicates: " + numbers);
        System.out.println("Collection without duplicates: "
                + removeDoublesInCollection(numbers) + "\n");



        System.out.println("Task2:");
        /*
         * 2. Напишите метод, который добавляет 1млн элементов в ArrayList и LinkedList.
         *  Напишите метод, который выбирает из заполненного списка элемент наугад 100000 раз.
         *  Замерьте время, которое потрачено на это.
         *  Сравните результаты, предположите, почему они именно такие.
         * */
        ArrayList<Double> arrayList = addMillionElementsToArrayList(1000000);
        LinkedList<Double> linkedList = addMillionElementsToLinkedList(1000000);
        System.out.println("ArrayList processing time: "
                + randomTakerFromList(arrayList, 100000));
        System.out.println("LinkedList processing time: "
                + randomTakerFromList(linkedList, 100000) + "\n");

        /*
        * Выборка значений из ArrayList быстрее, чем в LinkedList.
        * В LinkedList операции доступа по индексу производятся перебором
        * с начала или конца (смотря что ближе) до нужного элемента.
        * А ArrayList - список на основе массива, потому доступ по индексу
        * отрабатывает быстрее.
        * */


        System.out.println("Task3:");
        /*
         *3.	Опишите класс User с одним полем name.
         * Добавьте конструктор, сеттер и геттер.
         * Создайте Map, в котором для каждого пользователя хранится количество очков,
         * заработанных в какой-то игре (Map<User, Integer>).
         * Напишите программу, которая считывает с консоли имя и показывает,
         * сколько очков у такого пользователя.
         * Сами данные можно добавить в Map при создании или сгенерировать случайно.
         */
        Random random = new Random();
        Map<User, Integer> userGameScore = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            User user = new User("Player_" + i);
            userGameScore.put(user, random.nextInt(200) * i);

        }
        System.out.println(viewGameScore(userGameScore) + "\n");



        System.out.println("Task4:");
        /*
         *4. Метод получает на вход массив элементов типа К.
         * Вернуть нужно объект Map<K, Integer>,
         * где K — Значение из массива, а Integer
         * количество вхождений в массив:
         * <K> Map<K, Integer> arrayToMap(K[] ks);
         */
        String[] array = new String[]{"String1", "String2", "StringTest", "StringTest"};
        System.out.println("Array to Map result: " + arrayToMap(array));




    }


    //Task 1
    public static <T> Collection<T> removeDoublesInCollection (Collection<T> collection) {

        return new HashSet<>(collection);
    }


    //Task 2
    public static ArrayList<Double> addMillionElementsToArrayList (int elements) {
        ArrayList<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < elements; i++) {
            arrayList.add(Math.random());
        }
        return arrayList;
    }

    public static LinkedList<Double> addMillionElementsToLinkedList (int elements) {
        LinkedList<Double> linkedList = new LinkedList<>();

        for (int i = 0; i < elements; i++) {
            linkedList.add(Math.random());
        }
        return linkedList;
    }

    public static String randomTakerFromList (List list, int iterations) {
        LocalTime startTime = LocalTime.now();

        for (int i = 0; i < iterations; i++) {
            list.get((int) (Math.random() * (iterations - 1)));
        }
        LocalTime endTime = LocalTime.now();
        if ((endTime.getNano() - startTime.getNano() < 0)){
            return endTime.getSecond() - startTime.getSecond() + " sec";
        }
        return endTime.getNano() - startTime.getNano() + " nsec";
    }


    //Task3
    public static String viewGameScore(Map<User, Integer> map){
        Scanner in = new Scanner(System.in);
        System.out.println("Please put user name: " + "\n");
        String userName = in.next();


        for (User u:map.keySet()) {


            if(u.getName().equalsIgnoreCase(userName)){
                return "Result: " + userName + " scored " + map.get(u) + " points";
            }
        }
        return "User " + userName + " not founded";
    }


    //Task4
    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> myMap = new HashMap<>();
        for (K k : ks) {
            myMap.compute(k, (k1, count)
                    -> count == null ? 1 : count + 1);
        }

        return myMap;
    }


}
