package com.hotel.reservationsystem.enums;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    DOUBLE_2(4),
    PENTHOUSE(8);

    public final int maxGuests;

    RoomType(int maxGuests) {
        this.maxGuests = maxGuests;
    }

//    public static RoomType valueOfMaxGuest(int maxGuests){
//        return RoomType.valueOfMaxGuest();
//    }
}