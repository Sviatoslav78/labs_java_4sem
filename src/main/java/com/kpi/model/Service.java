package com.kpi.model;


import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Service {
    private final Subscriber[] subscribers;
    FileManipulation fileManipulation;

    public Subscriber[] getSubscribers() {
        return subscribers;
    }

    public Service() throws FileNotFoundException, JsonSyntaxException, NoSuchElementException {
        fileManipulation = new FileManipulation();
        subscribers = fileManipulation.readFromFile();
    }

    public Subscriber[] getOverTimedSubs(int hour, int minute) {
        Subscriber[] result = new Subscriber[subscribers.length];
        String[] foundTime;

        int i = 0;
        for (Subscriber sub : subscribers) {
            foundTime = sub.getLocalTalks().split(":");

            if (Integer.parseInt(foundTime[0]) > hour) {
                result[i] = sub;
                i++;
            } else if (Integer.parseInt(foundTime[0]) == hour) {

                if (Integer.parseInt(foundTime[1]) > minute) {
                    result[i] = sub;
                    i++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }

    public Subscriber[] getGlobalCallingSubs() {
        Subscriber[] result = new Subscriber[subscribers.length];
        String[] foundTime;

        int i = 0;
        for (Subscriber sub : subscribers) {
            foundTime = sub.getGlobalTalks().split(":");

            if (Integer.parseInt(foundTime[0]) == 0 &&
                    Integer.parseInt(foundTime[1]) == 0) {
            } else {
                result[i] = sub;
                i++;
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }

    public void recordData(Subscriber[] subscribers, String fileName) throws IOException {
        fileManipulation.writeToFile(subscribers, fileName);
    }
}
