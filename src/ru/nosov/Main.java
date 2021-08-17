package ru.nosov;

import java.lang.reflect.Type;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Taks 1
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6);
        removeDoublesInCollection(Collections.singleton(numbers));
        System.out.println(numbers);



        //Task 2

    }

    public static <T> Collection<T> removeDoublesInCollection (Collection<T> collection) {

        return new HashSet<>(collection);
    }



    public static void addMillionElementsArrayList () {
        ArrayList<String> arrayList = new ArrayList<>();
        String element = null;

        for (int i = 0; i < 1000000; i++) {
            arrayList.add(element);
        }
        System.out.println("addMillionElementsArrayList is Done");
    }

    public static void addMillionElementsLinkedList () {
        LinkedList<String> linkedList = new LinkedList<>();

        String element = null;

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(element);
        }
        System.out.println("addMillionElementsLinkedList is Done");
    }

    public static void randomTakerFromList (List list) {
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            list.get(random.nextInt());


        }
        System.out.println("randomTakerFromList is Done");
    }
}
