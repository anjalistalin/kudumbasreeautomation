package com.example.kudumbasree;

public class BorrowersModelClass {
    String LoanName, Loanid, LoanAmount, PayAmount, InstallmentNo;

    public BorrowersModelClass() {
    }

    public BorrowersModelClass(String loanName, String loanid, String loanAmount, String payAmount, String installmentNo) {
        LoanName = loanName;
        Loanid = loanid;
        LoanAmount = loanAmount;
        PayAmount = payAmount;
        InstallmentNo = installmentNo;
    }

    public String getLoanName() {
        return LoanName;
    }

    public void setLoanName(String loanName) {
        LoanName = loanName;
    }

    public String getLoanid() {
        return Loanid;
    }

    public void setLoanid(String loanid) {
        Loanid = loanid;
    }

    public String getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        LoanAmount = loanAmount;
    }

    public String getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(String payAmount) {
        PayAmount = payAmount;
    }

    public String getInstallmentNo() {
        return InstallmentNo;
    }

    public void setInstallmentNo(String installmentNo) {
        InstallmentNo = installmentNo;
    }
}


