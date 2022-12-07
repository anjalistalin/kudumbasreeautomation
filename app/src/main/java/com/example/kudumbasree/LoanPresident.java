package com.example.kudumbasree;

public class LoanPresident {

    String LoanName, LoanId, Category, Amount, Permonth, Period, Interest, LastDate;

    public LoanPresident() {
    }

    public LoanPresident(String loanName, String loanid, String category, String amount, String permonth, String period, String interest, String lastdate) {
        LoanName = loanName;
        LoanId = loanid;
        Category = category;
        Amount = amount;
        Permonth = permonth;
        Period = period;
        Interest = interest;
        LastDate = lastdate;
    }

    public String getLoanName() {
        return LoanName;
    }

    public void setLoanName(String loanName) {
        LoanName = loanName;
    }

    public String getLoanId() {
        return LoanId;
    }

    public void setLoanId(String loanid) {
        LoanId = loanid;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getPermonth() {
        return Permonth;
    }

    public void setPermonth(String permonth) {
        Permonth = permonth;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String interest) {
        Interest = interest;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastdate) {
        LastDate = lastdate;
    }
}
