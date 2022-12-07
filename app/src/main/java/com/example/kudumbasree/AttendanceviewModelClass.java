package com.example.kudumbasree;

public class AttendanceviewModelClass {
    String Name,Date;

    public AttendanceviewModelClass() {
    }

    public AttendanceviewModelClass(String name, String date) {
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
