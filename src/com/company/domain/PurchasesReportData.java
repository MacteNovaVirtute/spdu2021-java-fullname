package com.company.domain;

import java.time.Month;
import java.util.List;
import java.util.Map;

public class PurchasesReportData {

    Map<Month, List<Purchase>> activeCustomers;
    Map<Month, List<Purchase>> inactiveCustomers;

    public PurchasesReportData(
        Map<Month, List<Purchase>> activeCustomers,
        Map<Month, List<Purchase>> inactiveCustomers
    ) {
        this.activeCustomers = activeCustomers;
        this.inactiveCustomers = inactiveCustomers;
    }

    public Map<Month, List<Purchase>> getActiveCustomers() {
        return activeCustomers;
    }

    public Map<Month, List<Purchase>> getInactiveCustomers() {
        return inactiveCustomers;
    }
}
