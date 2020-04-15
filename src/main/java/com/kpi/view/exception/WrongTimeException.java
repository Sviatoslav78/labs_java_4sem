package com.kpi.view.exception;

import java.io.IOException;

public class WrongTimeException extends IOException {
    public WrongTimeException(String message) {
        super(message);
    }
}
