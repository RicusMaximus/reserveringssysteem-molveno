package com.hotel.reservationsystem.enums;

public enum RoomType {
    SINGLE("Single Room"),
    DOUBLE("Double Room"),
    DOUBLE_2("2x Double Room"),
    PENTHOUSE("Penthouse");

    private String roomType;

    RoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return roomType;
    }
}