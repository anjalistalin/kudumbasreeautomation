package com.example.kudumbasree;

public class MemberlistModelClass {
    String Name,PhoneNo;

    public MemberlistModelClass() {
    }

    public MemberlistModelClass(String name, String phoneNo) {
        Name = name;
        PhoneNo = phoneNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
}
