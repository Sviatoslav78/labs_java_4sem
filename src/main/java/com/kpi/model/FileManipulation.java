package com.kpi.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileManipulation {
    Gson gson;

    public FileManipulation() {
        gson = new Gson();
    }

    public Subscriber[] readFromFile() throws JsonSyntaxException, FileNotFoundException, NoSuchElementException {
        File file = new File("subscribers.txt");
        Scanner scanner = new Scanner(file);

        Subscriber[] subscribers = gson.fromJson(scanner.nextLine(), Subscriber[].class);
        scanner.close();
        return subscribers;
    }

    public void writeToFile(Subscriber[] subscribers, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        fileWriter.write(gson.toJson(subscribers));
        fileWriter.close();
    }
}
