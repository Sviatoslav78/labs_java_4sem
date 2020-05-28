package com.kpi.view;

import com.kpi.model.Subscriber;

public class View {
    private InputOfData inputOfData;

    public View() {
        inputOfData = new InputOfData(this);
    }

    public void showMenu() {
        System.out.println("1. Subscribers with time of local calls over limit\n" +
                "2. Subscribers who used global calls\n" +
                "3. Show all subscribers\n" +
                "4. Exit");
    }

    public int getCommand() {
        int menuItem;

        while (true) {
            menuItem = inputOfData.inputCommand();
            if (menuItem != -1)
                return menuItem;
        }
    }

    public int[] getLimit() {
        int[] limit;

        while (true) {
            limit = inputOfData.timeLimitInput();
            if (limit[0] != -1)
                return limit;
        }
    }

    public void showSubscribers(Subscriber[] subscribers) {
        if (subscribers.length == 0) {
            System.out.println("No such subscribers found");
        } else {
            for (Subscriber sub : subscribers) {
                System.out.println(sub);
            }

        }
    }

    public void showMessage(String string) {
        System.out.println(string);
    }

    public void showError(String error) {
        System.err.println(error);
    }

    public String getFileName() {
        return inputOfData.getOutputFileName();
    }

    public String getFileWriteConfirmation() {
        return inputOfData.getConfirmation();

    }
}
