package com.hotel.reservationsystem.enums;

public enum TitleType {
    MR("Mr."),
    MS("Ms."),
    MRS("Mrs.");

    private String title;

    TitleType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

