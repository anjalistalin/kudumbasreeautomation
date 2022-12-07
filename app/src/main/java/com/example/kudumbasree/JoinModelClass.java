package com.example.kudumbasree;

public class JoinModelClass {
    String KudumbasreeName,WardNo;

    public JoinModelClass() {
    }

    public JoinModelClass(String kudumbasreeName, String wardNo) {
        KudumbasreeName = kudumbasreeName;
        WardNo = wardNo;
    }

    public String getKudumbasreeName() {
        return KudumbasreeName;
    }

    public void setKudumbasreeName(String kudumbasreeName) {
        KudumbasreeName = kudumbasreeName;
    }

    public String getWardNo() {
        return WardNo;
    }

    public void setWardNo(String wardNo) {
        WardNo = wardNo;
    }
}
