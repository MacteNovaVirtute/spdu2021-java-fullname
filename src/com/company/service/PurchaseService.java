package com.company.service;

import com.company.domain.Customer;
import com.company.domain.PaymentDetails;
import com.company.domain.Purchase;
import com.company.domain.PurchasesReportData;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class PurchaseService {

    private final CustomerService customerService;
    private final List<Purchase> log = new ArrayList<>();

    public PurchaseService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void logPurchase(Month month, Customer customer, BigDecimal amount, List<PaymentDetails> paymentDetails) {

        Purchase purchase = new Purchase(month, customer, amount, paymentDetails);
        log.add(purchase);
    }

    public PurchasesReportData prepareReport(Month month) {

        List<Customer> allCustomers = customerService.getCustomers();

        Set<Customer> activeCustomers = log.stream()
            .filter(purchase -> month.equals(purchase.getMonth()))
            .map(Purchase::getCustomer).collect(toSet());

        List<Customer> inactiveCustomers = allCustomers.stream()
            .filter(customer -> !activeCustomers.contains(customer)).collect(toList());

        Map<Month, List<Purchase>> activeByMonths = log.stream().
            filter(purchase -> activeCustomers.contains(purchase.getCustomer()))
            .collect(Collectors.groupingBy(Purchase::getMonth));

        Map<Month, List<Purchase>> inactiveByMonths = log.stream()
            .filter(purchase -> inactiveCustomers.contains(purchase.getCustomer()))
            .collect(Collectors.groupingBy(Purchase::getMonth));

        return new PurchasesReportData(activeByMonths, inactiveByMonths);
    }

    public void printReport(PurchasesReportData reportData) {

        System.out.println("Active buyers:");
        printCustomers(reportData.getActiveCustomers());

        System.out.println("Inactive buyers:");
        printCustomers(reportData.getInactiveCustomers());
    }

    private void printCustomers(Map<Month, List<Purchase>> customersByMonth) {

        customersByMonth.forEach((key, value) -> {

            System.out.println(key);
            value.forEach(purchase -> {
                Customer customer = purchase.getCustomer();
                String customerString = String.format("    %s %s (%s): $%.2f (%s)",
                    customer.getName(),
                    customer.getLastName(),
                    customer.getPhoneNumber(),
                    purchase.getTotalCost(),
                    purchase.getPaymentDetails().stream()
                        .map(details -> String.format("%s: $%.2f", details.getType(), details.getAmount()))
                        .collect(Collectors.joining(", "))
                );

                System.out.println(customerString);
            });
        });
    }
}
