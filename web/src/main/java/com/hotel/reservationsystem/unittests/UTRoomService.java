package com.hotel.reservationsystem.unittests;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.repositories.RoomRepository;
import com.hotel.reservationsystem.services.RoomService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UTRoomService {
    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomService roomService;

    @Test
    public void getAllRooms_CompareFullListOfRoomsWithFullListOfRooms_ReturnsTrue() {
        List<Room> roomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));

        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllRooms();

        assertEquals(roomList.size(), retrievedRooms.size());
    }

    @Test
    public void getAllRooms_CompareFullListOfRoomsWithEmptyListOfRooms_ReturnsFalse() {
        List<Room> roomList = new ArrayList<>();
        List<Room> emptyRoomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));

        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllRooms();

        assertNotEquals(emptyRoomList.size(), retrievedRooms.size());
    }

    @Test
    public void getAllRooms_CompareEmptyListOfRoomsWithEmptyListOfRooms_ReturnsTrue() {
        List<Room> roomList = new ArrayList<>();
        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllRooms();

        assertEquals(roomList.size(), retrievedRooms.size());
    }

    @Test
    public void getAllAvailableRooms_CompareFullListOfRoomsWithFullListOfRooms_ReturnsTrue() {
        List<Room> roomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, true));

        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllAvailableRooms();

        assertNotEquals(roomList, retrievedRooms);
        assertEquals(1, retrievedRooms.size());
    }

    @Test
    public void getAllAvailableRooms_CompareFullListOfRoomsWithEmptyListOfRooms_ReturnsFalse() {
        List<Room> roomList = new ArrayList<>();
        List<Room> emptyRoomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, true));

        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllAvailableRooms();

        assertNotEquals(emptyRoomList, retrievedRooms);
    }

    @Test
    public void getAllAvailableRooms_CompareEmptyListOfRoomsWithEmptyListOfRooms_ReturnsTrue() {
        List<Room> roomList = new ArrayList<>();
        when(roomRepository.getRooms()).thenReturn(roomList);
        List<Room> retrievedRooms = roomService.getAllAvailableRooms();

        assertEquals(roomList.size(), retrievedRooms.size());
    }

    @Test
    public void getRoomByID_GetRoomFromListBasedOnExistingID_ReturnsTrue() {
        List<Room> roomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, true));

        when(roomRepository.getRooms()).thenReturn(roomList);
        Room retrievedRoom = roomService.getRoomById(1);

        assertEquals(roomList.toArray()[0], retrievedRoom);
    }

    @Test
    public void getRoomByID_GetRoomFromListBasedOnNotExistingID_ReturnsFalse() {
        List<Room> roomList = new ArrayList<>();

        roomList.add(new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        roomList.add(new Room(2, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, true));

        when(roomRepository.getRooms()).thenReturn(roomList);
        Room retrievedRoom = roomService.getRoomById(5);

        assertNotEquals(roomList.toArray()[0], retrievedRoom);
    }

//    @Test
//    public void deleteRoomByID_DeleteRoomFromListBasedOnExistingID_ReturnsTrue() {
//        List<Room> roomList = new ArrayList<>();
//
//        Room room_1 = new Room(1, 2, 0,"2x Double",
//                RoomType.PENTHOUSE, true, false);
//        Room room_2 = new Room(2, 2, 0,"2x Double",
//                RoomType.PENTHOUSE, true, true);
//
//        roomList.add(room_1);
//        roomList.add(room_2);
//
//        when(roomRepository.deleteRoom(room_1)).then(roomList.remove(room_1)).then(roomList));
//
//        when(roomRepository.deleteRoom(room_1)).thenAnswer(roomList.remove(room_1));
//
//        Room deletedRoom = roomService.deleteRoomByID(1);
//        when(roomRepository.deleteRoom(deletedRoom)).thenReturn(roomList.remove(roomList));
//
//        assertNotEquals(roomList.toArray()[0], retrievedRoom);
//    }

    @Test
    public void createRoom_AddRoomByProvidingNewCorrectRoomObject_ReturnsTrue() {
        Room room = new Room(1, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false);

        when(roomRepository.addRoom(room)).thenReturn(room);
        Room addedRoom = roomService.createRoom(room);

        assertEquals(room, addedRoom);
    }

//    @Test
//    public void createRoom_AddRoomByProvidingNewNullRoomObject_ReturnsTrue() {
//        Room room = null;
//
//        when(roomRepository.addRoom(room)).thenReturn(room);
//        Room addedRoom = roomService.createRoom(room);
//
//        assertEquals(room, addedRoom);
//    }
}
