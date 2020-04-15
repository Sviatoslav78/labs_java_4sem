package com.kpi.view;

import com.kpi.model.Subscriber;

public class View {
    private DataInput dataInput;

    public View() {
        dataInput = new DataInput();
    }

    public void showMenu() {
        System.out.println("1. Show subscribers with time of local calls over limit\n" +
                "2. Show subscribers who used global calls\n" +
                "3. Show all subscribers\n" +
                "4. Exit");
    }

    public int getCommand() {
        int menuItem;

        while (true) {
            menuItem = dataInput.inputCommand();
            if (menuItem != -1)
                return menuItem;
        }
    }

    public int[] getLimit() {
        int[] limit;

        while (true) {
            limit = dataInput.timeLimitInput(this);
            if (limit[0] != -1)
                return limit;
        }
    }

    public void showSubscribers(Subscriber[] subscribers) {
        int isEmpty = 0;

        for (int i = 0; i < subscribers.length; i++) {
            if (subscribers[i] == null) {
                isEmpty++;
            } else {
                System.out.println(subscribers[i]);
            }
        }
        if (isEmpty == subscribers.length) {
            System.out.println("No such subscribers found");
        }
        System.out.println();
    }

    public void showMessage(String string) {
        System.out.println(string);
    }
}
