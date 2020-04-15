package com.kpi.view.exception;

import java.io.IOException;

public class WrongMenuItemException extends IOException {
    public WrongMenuItemException(String message) {
        super(message);
    }
}
