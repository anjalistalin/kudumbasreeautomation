package com.example.kudumbasree;

public class AttendanceModelClass {
    String Name,Date;

    public AttendanceModelClass() {
    }

    public AttendanceModelClass(String value) {
    }

    public AttendanceModelClass(String name, String date) {
        Name = name;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
