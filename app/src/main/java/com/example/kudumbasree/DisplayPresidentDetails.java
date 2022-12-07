package com.example.kudumbasree;

public class DisplayPresidentDetails {
    String name,unitname,place,district;

    public DisplayPresidentDetails() {
    }

    public DisplayPresidentDetails(String name, String unitname, String place, String district) {
        this.name = name;
        this.unitname = unitname;
        this.place = place;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
