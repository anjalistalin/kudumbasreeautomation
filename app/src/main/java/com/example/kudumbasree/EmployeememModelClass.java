package com.example.kudumbasree;

public class EmployeememModelClass {
    String Name,Phoneno;

    public EmployeememModelClass() {
    }

    public EmployeememModelClass(String name, String phoneno) {
        Name = name;
        Phoneno = phoneno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }
}
