package com.example.kudumbasree;

public class PayinfoModelClass {
    String Loanid,InstallmentNo,PayAmount;

    public PayinfoModelClass() {
    }

    public PayinfoModelClass(String loanid, String installmentNo, String payAmount) {
        Loanid = loanid;
        InstallmentNo = installmentNo;
        PayAmount = payAmount;
    }

    public String getLoanid() {
        return Loanid;
    }

    public void setLoanid(String loanid) {
        Loanid = loanid;
    }

    public String getInstallmentNo() {
        return InstallmentNo;
    }

    public void setInstallmentNo(String installmentNo) {
        InstallmentNo = installmentNo;
    }

    public String getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(String payAmount) {
        PayAmount = payAmount;
    }
}
