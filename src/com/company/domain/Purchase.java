package com.company.domain;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class Purchase {
    private final Month month;
    private final Customer customer;
    private final BigDecimal totalCost;
    private final List<PaymentDetails> paymentDetails;

    public Purchase(
        Month month,
        Customer customer,
        BigDecimal totalCost,
        List<PaymentDetails> paymentDetails
    ) {
        this.month = month;
        this.customer = customer;
        this.totalCost = totalCost;
        this.paymentDetails = paymentDetails;
    }

    public Month getMonth() {
        return month;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }
}
