package ru.nosov;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserGameScope {

    private final Scanner in = new Scanner(System.in);
    private final Random random = new Random();

    Map<User,Integer> userGameScope = new HashMap<>();


    public Map<User,Integer> fillValues() {
        for (int i = 1; i <= 5; i++) {
            userGameScope.put(new User("Player" + i), random.nextInt() * i);
        }
        return userGameScope;
    }

    private String getUserNameFromConsole (){
        System.out.println("Please put user name: " + "\n");

        return in.next();
    }

    public Integer getUserGameScope() {
        String userName = getUserNameFromConsole();

        return userGameScope.get(userName);
    }

    public void setUserGameScope(String userName, Integer gameScope) {
        userGameScope.put(new User(userName),gameScope);
    }
}
