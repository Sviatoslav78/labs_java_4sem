package com.kpi.model;

import static java.lang.Math.random;

public class DataSource {

    public static Subscriber[] createEntities() {
        Subscriber[] entities = new Subscriber[10];
        for (int i = 0; i < entities.length; i++) {
            entities[i] = getRandomSub();
        }
        return entities;
    }

    private static Subscriber getRandomSub() {
        String[] names = {"Igor", "Aleksandr", "Valentin", "Ivan", "Nazar"};
        String[] surnames = {"Smirnov", "Ivanov", "Sokolov", "Popov", "Lebedev"};
        String[] patronymics = {"Igorevich", "Aleksandrovich", "Ivanovich", "Nicolaevich", "Dmytrovich"};
        String[] addresses = {"Yangel st.", "Lenin st.", "Ogorodna st.", "Pushkin st.", "Khreshchatyk st."};

        return new Subscriber(names[(int) (random() * 5)],
                surnames[(int) (random() * 5)],
                patronymics[(int) (random() * 5)],
                addresses[(int) (random() * 5)],
                (int) (random() * 5) + ":" + (int) (random() * 60),
                (int) (random() * 5) + ":" + (int) (random() * 60));
    }
}
