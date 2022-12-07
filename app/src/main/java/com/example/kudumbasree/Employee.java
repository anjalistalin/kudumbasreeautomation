package com.example.kudumbasree;

public class Employee {
    String KudumbasreeName,PhoneNo,Name;

    public Employee() {
    }

    public Employee(String kudumbasreeName, String phoneNo, String name) {
        KudumbasreeName = kudumbasreeName;
        PhoneNo = phoneNo;
        Name = name;
    }

    public String getKudumbasreeName() {
        return KudumbasreeName;
    }

    public void setKudumbasreeName(String kudumbasreeName) {
        KudumbasreeName = kudumbasreeName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
