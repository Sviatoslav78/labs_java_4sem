package com.kpi.controller;

import com.kpi.model.Service;
import com.kpi.view.View;

public class Controller {
    private View view;
    private Service service;

    public Controller() {
        view = new View();
        service = new Service();
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
                view.showSubscribers(service.getOverTimedSubs(timeLimit[0], timeLimit[1]));
                break;
            case 2:
                view.showSubscribers(service.getGlobalCallingSubs());
                break;
            case 3:
                view.showSubscribers(service.getSubscribers());
                break;
            case 4:
                System.exit(0);
        }
    }

}
