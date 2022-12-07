package com.example.kudumbasree;

public class RequestloanModelClass {
    String Memno,TotalAmount,UnitId,UnitName;

    public RequestloanModelClass() {
    }

    public RequestloanModelClass(String memno, String totalAmount, String unitId, String unitName) {
        Memno = memno;
        TotalAmount = totalAmount;
        UnitId = unitId;
        UnitName = unitName;
    }

    public String getMemno() {
        return Memno;
    }

    public void setMemno(String memno) {
        Memno = memno;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String unitId) {
        UnitId = unitId;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }
}
