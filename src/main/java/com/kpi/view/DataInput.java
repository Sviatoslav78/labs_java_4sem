package com.kpi.view;

import java.util.Scanner;

public class DataInput {
    private Validator validator;
    private Scanner scanner;

    public DataInput() {
        validator = new Validator();
        scanner = new Scanner(System.in);
    }

    public int inputCommand(View view) {
        while (true) {
            String stringCommand = scanner.nextLine();

            if (validator.isValidCommand(stringCommand)) {
                return Integer.parseInt(stringCommand.trim());
            } else {
                view.showMessage("Enter valid menu command, please");
            }
        }
    }

    public int[] timeLimitInput(View view) {
        int hour, minute;
        int[] timeArray = new int[2];

        while (true) {
            view.showMessage("Enter time limit(hours firstly)\nhours(int): ");
            hour = checkForInt(view);
            view.showMessage("minutes: ");
            minute = checkForInt(view);

            if (validator.isValidTime(hour, minute))
                break;
        }
        timeArray[0] = hour;
        timeArray[1] = minute;

        return timeArray;
    }

    private int checkForInt(View view) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                view.showMessage("Enter int value, please");
            }
            scanner.nextLine();
        }
    }

}
