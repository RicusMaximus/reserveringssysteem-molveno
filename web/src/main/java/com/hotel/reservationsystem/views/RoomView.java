//package com.hotel.reservationsystem.views;
//
//import com.hotel.reservationsystem.controllers.RoomController;
//import com.hotel.reservationsystem.controllers.UserInputController;
//import com.hotel.reservationsystem.enums.RoomType;
//import com.hotel.reservationsystem.models.Room;
//
//public class RoomView {
//    private static RoomController roomController = RoomController.getInstance();
//
//    public static void showAllRooms () {
//        for (Room room : roomController.getAllRooms()) {
//            String availableText;
//
//            if(room.isAvailable()) { availableText = "available"; } else { availableText = "unavailable"; }
//
//            System.out.println(String.format("Room %s is %s. This room is a %s.", room.getRoomNumber(), availableText, room.getRoomTypeString()));
//        }
//    }
//
//    public static void showAllAvailableRooms() {
//        for (Room room : roomController.getAllAvailableRooms()) {
//            System.out.println(String.format("Room %s is available. This room is a %s.", room.getRoomNumber(), room.getRoomTypeString()));
//        }
//    }
//
//    public static void addNewRoomByInput() {
//        int roomNumber = UserInputController.returnIntInput("\nEnter a valid Room Number:");
//        int maxAdults = UserInputController.returnIntInput("\nEnter a valid maximum adults value:");
//        int maxChildren = UserInputController.returnIntInput("\nEnter a valid maximum children value:");
//        String bedAmount = UserInputController.returnStringInput("\nEnter a valid bed type:");
//        RoomType roomType = UserInputController.returnRoomTypeInput("Enter a valid room type:");
//        boolean disabledFriendly = UserInputController.returnBoolInput("\nDisabled friendly yes/no?");
//        boolean available = UserInputController.returnBoolInput("\nRoom currently available yes/no?");
//
//        //RoomController.createRoom(roomNumber, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available);
//    }
//}
