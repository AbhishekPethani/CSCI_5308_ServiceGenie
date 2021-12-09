package com.servicegenie.constants;

public enum CustomerUtil {

    COUPON_SUCCESS("Code Applied"), COUPON_FAILURE("Unable to apply coupon code"),
    ORDER_SUCCESS("Order Placed Successfully"), ORDER_FAILURE("Unable to apply coupon code"),
    CUSTOMER_EMAIL("arjun@test.com"), CUSTOMER_ID("arjun123"),
    QUERY_SERVICE_DETAILS("SELECT * FROM services_details;");

    private final String constantString;

    private CustomerUtil(String constantString) {
        this.constantString = constantString;
    }

    @Override
    public String toString() {
        return constantString;
    }
}
