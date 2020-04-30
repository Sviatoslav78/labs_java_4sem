package com.kpi.controller;

import com.google.gson.JsonSyntaxException;
import com.kpi.model.Service;
import com.kpi.model.Subscriber;
import com.kpi.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Controller {
    private View view;
    private Service service;

    public Controller() {
        view = new View();
        try {
            service = new Service();
        } catch (JsonSyntaxException | FileNotFoundException | NoSuchElementException e ) {
            view.showError("No input file or its invalid structure(fatal error)");
            System.exit(-1);
        }
    }

    public void run() {
        int command;

        while (true) {
            view.showMenu();
            command = view.getCommand();
            executeCommand(command);
        }
    }

    public void executeCommand(int command) {
        switch (command) {
            case 1:
                int[] timeLimit = view.getLimit();
                Subscriber[] finalLimitedSubs = service.getOverTimedSubs(timeLimit[0], timeLimit[1]);
                view.showSubscribers(finalLimitedSubs);

                writeToFileAbility(finalLimitedSubs);
                break;
            case 2:
                Subscriber[] finalGlobalCallingSubs = service.getGlobalCallingSubs();
                view.showSubscribers(finalGlobalCallingSubs);

                writeToFileAbility(finalGlobalCallingSubs);
                break;
            case 3:
                view.showSubscribers(service.getSubscribers());
                break;
            case 4:
                System.exit(0);
        }
    }

    public void writeToFileAbility(Subscriber[] subs) {
        view.showMessage("Do you want to write data to file?\n1.yes\n2.no");

        if (view.getFileWriteConfirmation().equals("1")) {

            try {
                service.recordData(subs, view.getFileName());
                view.showMessage("Recorded\n");
            } catch (IOException e) {
                view.showError("Error while recording data to file");
            }
        } else {
            view.showMessage("Result wasn't written to file\n");
        }
    }

}
