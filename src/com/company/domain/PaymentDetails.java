package com.company.domain;

import java.math.BigDecimal;

// (cash: $100, card: $200)
public class PaymentDetails {

    private Type type;
    private BigDecimal amount;

    public PaymentDetails(Type type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    public enum Type {
        CARD,
        CASH
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
