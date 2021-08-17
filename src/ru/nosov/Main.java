package ru.nosov;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Task1
        System.out.println("Task1:");
        ArrayList<String> numbers = new ArrayList<String>() ;
        numbers.add("Add");
        numbers.add("some");
        numbers.add("test");
        numbers.add("test");
        numbers.add("elements");

        System.out.println("Collection with duplicates: " + numbers);
        System.out.println("Collection without duplicates: "
                + removeDoublesInCollection(numbers) + "\n");


        //Task2
        System.out.println("Task2:");
        ArrayList<Double> arrayList = addMillionElementsToArrayList();
        LinkedList<Double> linkedList = addMillionElementsToLinkedList();
        System.out.println("ArrayList processing time in ns: "
                + randomTakerFromList(arrayList));
        System.out.println("LinkedList processing time in ns: "
                + randomTakerFromList(linkedList) + "\n");

        //Task3
        System.out.println("Task3:");
        Random random = new Random();
        Scanner in = new Scanner(System.in);



//        UserGameScope userGameScope = new UserGameScope();
//        userGameScope.fillValues();
//
//        User myPlayer = new User("myPlayer");
//        userGameScope.setUserGameScope(myPlayer.getName(),666);
//        //System.out.println(userGameScope.getUserGameScope());
//        System.out.println(userGameScope);




        Map<User, Integer> userGameScope = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User("Player" + i);
            userGameScope.put(user, random.nextInt(200) * i);
        }
        User myPlayer = new User("myPlayer");
        userGameScope.put(myPlayer,666);
        System.out.println("Please put user name: " + "\n");
        System.out.println(userGameScope.get(myPlayer.getName()));;

        System.out.println(userGameScope);



    }


    //Task 1
    /*1 Написать метод, который на входе получает коллекцию объектов,
     *а возвращает коллекцию уже без дубликатов.
     *Для решения этой задачи пригодится Set.
     */
    public static <T> Collection<T> removeDoublesInCollection (Collection<T> collection) {

        return new HashSet<>(collection);
    }


    //Task 2
    /*
     * 2. Напишите метод, который добавляет 1млн элементов в ArrayList и LinkedList.
     *  Напишите метод, который выбирает из заполненного списка элемент наугад 100000 раз.
     *  Замерьте время, которое потрачено на это.
     *  Сравните результаты, предположите, почему они именно такие.
     * */

    public static ArrayList<Double> addMillionElementsToArrayList () {
        ArrayList<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            arrayList.add(Math.random());
        }
        return arrayList;
    }

    public static LinkedList<Double> addMillionElementsToLinkedList () {
        LinkedList<Double> linkedList = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(Math.random());
        }
        return linkedList;
    }

    public static long randomTakerFromList (List list) {
        Random random = new Random();
        LocalTime startTime = LocalTime.now();

        for (int i = 0; i < 100000; i++) {
            list.get((int) Math.random() * 999999);
        }
        LocalTime endTime = LocalTime.now();
        return endTime.getNano() - startTime.getNano();
    }


}
