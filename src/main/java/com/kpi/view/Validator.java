package com.kpi.view;

import com.kpi.view.exception.WrongMenuItemException;
import com.kpi.view.exception.WrongTimeException;

public class Validator {

    public void isValidCommand(String command) throws WrongMenuItemException {

        if (!command.trim().matches("[1-4]")) {
            throw new WrongMenuItemException("Menu item '" + command + "' is invalid, try again:");
        }
    }

    public void isValidTime(int hour, int minute) throws WrongTimeException {
        if (!(hour >= 0 && (minute >= 0 && minute < 60))) {
            throw new WrongTimeException("Invalid time '" + hour + ":" + minute + "', try again:");
        }
    }
}
