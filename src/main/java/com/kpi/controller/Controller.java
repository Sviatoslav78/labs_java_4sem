package com.kpi.controller;

import com.google.gson.JsonSyntaxException;
import com.kpi.model.Service;
import com.kpi.model.Subscriber;
import com.kpi.view.View;
import org.apache.log4j.Logger;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Controller {
    private View view;
    private Service service;
    private static final Logger logger = Logger.getLogger(Controller.class);

    public Controller() {
        logger.debug("Programme started");
        view = new View();
        try {
            service = new Service();
        } catch (JsonSyntaxException | FileNotFoundException | NoSuchElementException e ) {
            logger.fatal("No input file or its invalid structure: " + e);
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
                logger.info("User chose first menu item");
                int[] timeLimit = view.getLimit();
                logger.info("User set time limit for local talks: " + timeLimit[0] + " hour(-s) and " + timeLimit[1] + " minute(-s)");
                Subscriber[] finalLimitedSubs = service.getOverTimedSubs(timeLimit[0], timeLimit[1]);
                view.showSubscribers(finalLimitedSubs);
                logger.info(finalLimitedSubs.length + " subscriber(-s) was(were) found with local talks more than limit");

                writeToFileAbility(finalLimitedSubs);
                break;
            case 2:
                logger.info("User chose second menu item");
                Subscriber[] finalGlobalCallingSubs = service.getGlobalCallingSubs();
                view.showSubscribers(finalGlobalCallingSubs);
                logger.info(finalGlobalCallingSubs.length + " subscriber(-s) using global calls was(were) found");

                writeToFileAbility(finalGlobalCallingSubs);
                break;
            case 3:
                logger.info("User chose third menu item");
                view.showSubscribers(service.getSubscribers());
                logger.info("Subscribers from input file were shown in console");
                break;
            case 4:
                logger.debug("User chose 'Exit', programme finished successfully");
                System.exit(0);
        }
    }

    public void writeToFileAbility(Subscriber[] subs) {
        view.showMessage("Do you want to write data to file?\n1.yes\n2.no");

        if (view.getFileWriteConfirmation().equals("1")) {

            try {
                String filename = view.getFileName();
                service.recordData(subs, filename);
                view.showMessage("Recorded\n");
                logger.info("Subscribers were successfully recorded to file " + filename);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                view.showError("Error while recording data to file");
            }
        } else {
            view.showMessage("Result wasn't written to file\n");
            logger.info("User refused to write request results to file");
        }
    }

}
