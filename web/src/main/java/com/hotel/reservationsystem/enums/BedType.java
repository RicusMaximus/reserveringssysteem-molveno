package com.hotel.reservationsystem.enums;

public enum BedType {
    SINGLE("Single Bed"),
    DOUBLE("Double Bed"),
    BABY("Baby Bed");

    private String bed;

    BedType(String bed) {
        this.bed = bed;
    }

    @Override
    public String toString() {
        return bed;
    }
}