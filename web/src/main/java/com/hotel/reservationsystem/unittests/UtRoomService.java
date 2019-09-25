package com.hotel.reservationsystem.unittests;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.controllers.RoomController;
import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.repositories.RoomRepository;
import com.hotel.reservationsystem.services.RoomService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UtRoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    @Test
    public void getAllRooms_ReturnsListOfRooms() {
        Room room_1 = new Room(1,2, 0, "Double",
                RoomType.DOUBLE, true, true);
        Room room_2 = new Room(2, 2, 1, "Single",
                RoomType.DOUBLE_2, false, true);
        Room room_3 = new Room(3, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false);

        roomService.createRoom(room_1);
        roomService.createRoom(room_2);
        roomService.createRoom(room_3);

        List<Room> expectedResult = new ArrayList<>();
        expectedResult.add(room_1);
        expectedResult.add(room_2);
        expectedResult.add(room_3);

        List<Room> actualResult = roomService.getAllRooms();

        assertEquals(expectedResult, actualResult);
    }
}
