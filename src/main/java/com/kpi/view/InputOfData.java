package com.kpi.view;

import com.kpi.view.exception.WrongMenuItemException;
import com.kpi.view.exception.WrongTimeException;

import java.util.Scanner;

public class InputOfData {
    private Scanner scanner;
    private View view;
    private static final int INVALID_COMMAND = -1;

    public InputOfData(View view) {
        scanner = new Scanner(System.in);
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public int inputCommand() {
        String stringCommand = scanner.nextLine();
        if (!stringCommand.isEmpty()) {
            try {
                Validator.isValidCommand(stringCommand);

            } catch (WrongMenuItemException e) {
                view.showError(e.getMessage());
                return INVALID_COMMAND;
            }
            return Integer.parseInt(stringCommand.trim());
        }
        return INVALID_COMMAND;
    }

    public int[] timeLimitInput() {
        int hour, minute;
        int[] timeArray = new int[2];

        view.showMessage("Enter time limit(hours firstly)\nhours(int): ");
        hour = checkForInt();
        view.showMessage("minutes: ");
        minute = checkForInt();

        try {
            Validator.isValidTime(hour, minute);
            timeArray[0] = hour;
            timeArray[1] = minute;
        } catch (WrongTimeException e) {
            view.showError(e.getMessage());
            return new int[]{-1};
        }
        return timeArray;
    }

    private int checkForInt() {
        String intValue;

        while (true) {
            try {
                intValue = scanner.nextLine();
                return Integer.parseInt(intValue.trim());
            } catch (NumberFormatException e) {
                view.showError("hour and minute must be integer values, try again");
            }
        }
    }

    public String getInputFileName() {
        String fileName;
        view.showMessage("Input name of the file with subscriber's data: ");

        while (true) {
            fileName = scanner.nextLine();

            if (Validator.fileExists(fileName)) {
                return fileName;
            }
            view.showError("file not found, try again:");
        }
    }

    public String getOutputFileName() {
        String fileName;
        view.showMessage("Input name of the file to save subscriber's data:");

        while (true) {
            fileName = scanner.nextLine();
            if (Validator.isTextFile(fileName)) {
                return fileName;
            } else {
                view.showError("add .txt file extension, please");
            }
        }
    }

    public String getConfirmation() {
        return scanner.nextLine().trim();
    }

}
