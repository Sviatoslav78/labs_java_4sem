package com.kpi.model;


public class Service {
    private Subscriber[] subscribers;

    public Subscriber[] getSubscribers() {
        return subscribers;
    }

    public Service() {
        subscribers = DataSource.createEntities();
    }

    public Subscriber[] getOverTimedSubs(int hour, int minute) {
        Subscriber[] result = new Subscriber[10];
        String[] foundTime;

        for (int i = 0; i < subscribers.length; i++) {
            foundTime = subscribers[i].getLocalTalks().split(":");

            if (Integer.parseInt(foundTime[0]) > hour) {
                result[i] = subscribers[i];
            } else if (Integer.parseInt(foundTime[0]) == hour) {

                if (Integer.parseInt(foundTime[1]) > minute) {
                    result[i] = subscribers[i];
                }
            }
        }
        return result;
    }

    public Subscriber[] getGlobalCallingSubs() {
        Subscriber[] result = new Subscriber[10];
        String[] foundTime;

        for (int i = 0; i < subscribers.length; i++) {
            foundTime = subscribers[i].getGlobalTalks().split(":");

            if (Integer.parseInt(foundTime[0]) == 0 &&
                    Integer.parseInt(foundTime[1]) == 0) {
            } else {
                result[i] = subscribers[i];
            }
        }
        return result;
    }
}
