package com.kpi.model;

public class Subscriber {
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String localTalks;
    private String globalTalks;

    public Subscriber(String name, String surname, String patronymic, String address, String localTalks, String globalTalks) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.localTalks = localTalks;
        this.globalTalks = globalTalks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getLocalTalks() {
        return localTalks;
    }

    public String getGlobalTalks() {
        return globalTalks;
    }

    @Override
    public String toString() {

        String result = "Subscriber: " +
                "name: " + name +
                ", surname: " + surname +
                ", patronymic: " + patronymic +
                ", address: " + address;

        if (localTalks.split(":")[1].length() == 1) {
            result += ", time of local calls: 0" + localTalks.split(":")[0] + ":0" + localTalks.split(":")[1] + "(hh:mm)";
        } else {
            result += ", time of local calls: 0" + localTalks + "(hh:mm)";
        }

        if (globalTalks.split(":")[1].length() == 1) {
            result += ", time of global calls: 0" + globalTalks.split(":")[0] + ":0" + globalTalks.split(":")[1] + "(hh:mm)";
        } else {
            result += ", time of global calls: 0" + globalTalks + "(hh:mm)";
        }
        return result;
    }
}
