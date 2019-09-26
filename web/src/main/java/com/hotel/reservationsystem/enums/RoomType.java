package com.hotel.reservationsystem.enums;

public enum RoomType {
    SINGLE("Single Room"),
    DOUBLE("Double Room"),
    DOUBLE_2("2x Double Room"),
    PENTHOUSE("Penthouse");

    private String niceName;

    RoomType(String niceName) {
        this.niceName = niceName;
    }

    @Override
    public String toString() {
        return niceName;
    }
}