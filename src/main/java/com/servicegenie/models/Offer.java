package com.servicegenie.models;

public class Offer {
    private int offerID;
    private String offerCode;
    private Double minimumAmount;
    private Double discountPercentage;


    public Offer() {}

    public Offer(int offerID, String offerCode, Double minimumAmount, Double discountPercentage) {
        this.offerID = offerID;
        this.offerCode = offerCode;
        this.minimumAmount = minimumAmount;
        this.discountPercentage = discountPercentage;
    }


    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerID=" + offerID +
                ", offerCode='" + offerCode + '\'' +
                ", minimumAmount=" + minimumAmount +
                ", discountPercentage=" + discountPercentage +
                '}';
    }

}
