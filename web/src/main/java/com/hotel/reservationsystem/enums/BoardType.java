package com.hotel.reservationsystem.enums;

public enum BoardType {
    BED_AND_BREAKFAST("Bed and Breakfast"),
    HALF_BOARD("Half board"),
    ACCOMMODATIONS("Accommodations");

    private String boardType;

    BoardType(String boardType) {
        this.boardType = boardType;
    }

    @Override
    public String toString() {
        return boardType;
    }
}