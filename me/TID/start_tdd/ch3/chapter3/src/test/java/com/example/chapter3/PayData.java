package com.example.chapter3;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;
    private LocalDate firstBillingDate;

    public PayData() {
    }

    public PayData(LocalDate billingDate, int payAmount, LocalDate firstBillingDate) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
        this.firstBillingDate = firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.firstBillingDate = firstBillingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
