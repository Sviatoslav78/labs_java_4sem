package com.kpi.view;

import com.kpi.view.exception.WrongMenuItemException;
import com.kpi.view.exception.WrongTimeException;

import java.util.Scanner;

public class DataInput {
    private Validator validator;
    private Scanner scanner;
    private static final int INVALID_COMMAND =-1;


    public DataInput() {
        validator = new Validator();
        scanner = new Scanner(System.in);
    }

    public int inputCommand() {
            String stringCommand = scanner.nextLine();
            if (!stringCommand.isEmpty()) {
                try {
                    validator.isValidCommand(stringCommand);

                } catch (WrongMenuItemException e) {
                    System.err.println(e.getMessage());
                    return INVALID_COMMAND;
                }
                return Integer.parseInt(stringCommand.trim());
            }
            return INVALID_COMMAND;
    }

    public int[] timeLimitInput(View view) {
        int hour, minute;
        int[] timeArray = new int[2];

            view.showMessage("Enter time limit(hours firstly)\nhours(int): ");
            hour = checkForInt(view);
            view.showMessage("minutes: ");
            minute = checkForInt(view);

            try {
                validator.isValidTime(hour, minute);
                timeArray[0] = hour;
                timeArray[1] = minute;
            } catch (WrongTimeException e) {
                System.err.println(e.getMessage());
                return new int[]{-1};
            }

        return timeArray;
    }

    private int checkForInt(View view) {
        String intValue;

        while (true) {
            try {
                intValue = scanner.nextLine();
                return Integer.parseInt(intValue.trim());
            } catch (NumberFormatException e) {
                System.err.println("hour and minute must be integer values, try again");
            }
        }
    }

}
