package com.kpi.view;

public class Validator {

    public boolean isValidCommand(String command) {

        return command.trim().matches("1") ||
                command.trim().matches("2") ||
                command.trim().matches("3") ||
                command.trim().matches("4");
    }

    public boolean isValidTime(int hour, int minute) {
        if (hour >= 0 && (minute >= 0 && minute < 60)) {
            return true;
        }
        System.out.println("Input valid time\n");
        return false;
    }
}
