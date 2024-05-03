package com.ps;

import java.util.Date;

public class FinancialGoal {

    private String reason;
    private double currentAmount;
    private double targetAmount;
    private Date targetDate;

    public FinancialGoal(String reason, double currentAmount, double targetAmount, Date targetDate) {
        this.reason = reason;
        this.currentAmount = currentAmount;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "FinancialGoal{" +
                "reason='" + reason + '\'' +
                ", currentAmount=" + currentAmount +
                ", targetAmount=" + targetAmount +
                ", targetDate=" + targetDate +
                '}';
    }
}