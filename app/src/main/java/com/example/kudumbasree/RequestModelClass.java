package com.example.kudumbasree;

public class RequestModelClass {
    String Name,EmailId,Phoneno,DOB,Address;

    public RequestModelClass() {}

    public RequestModelClass(String name, String emailId, String phoneno, String dob,String address) {
        Name = name;
        EmailId = emailId;
        Phoneno = phoneno;
        DOB = dob;
        Address =address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dob) {
        DOB = dob;
    }
}
