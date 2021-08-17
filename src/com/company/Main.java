package com.company;

import com.company.domain.Customer;
import com.company.domain.PaymentDetails;
import com.company.domain.PurchasesReportData;
import com.company.service.CustomerService;
import com.company.service.PurchaseService;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

import static com.company.domain.PaymentDetails.Type.CARD;
import static com.company.domain.PaymentDetails.Type.CASH;
import static java.time.Month.AUGUST;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        PurchaseService purchaseService = new PurchaseService(customerService);

        Customer customer1 = customerService.registerCustomer("Elon", "Mask", "12.02.1993", "45678908765");
        Customer customer2 = customerService.registerCustomer("Bill", "Gates", "12.02.1995", "8767543234");
        Customer customer3 = customerService.registerCustomer("John", "Cena", "10.05.1964", "987654326754");

        List<PaymentDetails> paymentDetails1 = List.of(new PaymentDetails(CARD, new BigDecimal("100")));
        purchaseService.logPurchase(JULY, customer1, new BigDecimal("100"), paymentDetails1);

        List<PaymentDetails> paymentDetails2 = List.of(new PaymentDetails(CASH, new BigDecimal("200")));
        purchaseService.logPurchase(AUGUST, customer1, new BigDecimal("200"), paymentDetails2);

        List<PaymentDetails> paymentDetails3 = List.of(new PaymentDetails(CASH, new BigDecimal("200")),
            new PaymentDetails(CARD, new BigDecimal("300")));
        purchaseService.logPurchase(JUNE, customer2, new BigDecimal("500"), paymentDetails3);

        List<PaymentDetails> paymentDetails4 = List.of(new PaymentDetails(CARD, new BigDecimal("1000")),
            new PaymentDetails(CARD, new BigDecimal("100")));
        purchaseService.logPurchase(JULY, customer3, new BigDecimal("1100"), paymentDetails4);

        List<PaymentDetails> paymentDetails5 = List.of(new PaymentDetails(CARD, new BigDecimal("450")));
        purchaseService.logPurchase(JUNE, customer3, new BigDecimal("450"), paymentDetails5);

        PurchasesReportData reportData = purchaseService.prepareReport(AUGUST);
        purchaseService.printReport(reportData);
    }
}
