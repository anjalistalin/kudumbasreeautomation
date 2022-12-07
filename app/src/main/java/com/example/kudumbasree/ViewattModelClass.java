package com.example.kudumbasree;

import java.util.ArrayList;

public class ViewattModelClass {
    ArrayList<AttendanceModelClass> Present;

    public ViewattModelClass() {
    }

    public ViewattModelClass(ArrayList present) {
        Present = present;
    }

    public ArrayList getPresent() {
        return Present;
    }

    public void setPresent(ArrayList present) {
        Present = present;
    }
}
