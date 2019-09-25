package com.hotel.reservationsystem.services;

import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return this.roomRepository.getRooms();
    }

    public ArrayList<Room> getAllAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : this.roomRepository.getRooms()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Room getRoomById(int number) {
        Room roomById = null;

        for (Room room : this.roomRepository.getRooms()) {
            if (room.getRoomNumber() == number) {
                roomById = room;
            }
        }
        return roomById;
    }

    public Room createRoom(Room room){
        return roomRepository.addRoom(room);
    }
}
