package com.hotel.reservationsystem.enums;

public enum BoardType {
    BED_AND_BREAKFAST("Bed and Breakfast"),
    HALF_BOARD("Halfpension"),
    FULL_BOARD("Volpension"),
    ALL_INCLUSIVE("All inclusive");

    private String boardType;

    public String getBoardType() {
        return boardType;
    }

    BoardType(String s) {
        this.boardType = s;
    }
}
