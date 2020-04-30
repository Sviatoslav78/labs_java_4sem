package com.kpi.view;

import com.kpi.view.exception.WrongMenuItemException;
import com.kpi.view.exception.WrongTimeException;

import java.io.File;

public class Validator {

    public static void isValidCommand(String command) throws WrongMenuItemException {

        if (!command.trim().matches("[1-4]")) {
            throw new WrongMenuItemException("Menu item '" + command + "' is invalid, try again:");
        }
    }

    public static void isValidTime(int hour, int minute) throws WrongTimeException {
        if (!(hour >= 0 && (minute >= 0 && minute < 60))) {
            throw new WrongTimeException("Invalid time '" + hour + ":" + minute + "', try again:");
        }
    }

    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static boolean isTextFile(String fileName) {
        return fileName.contains(".txt");
    }
}
