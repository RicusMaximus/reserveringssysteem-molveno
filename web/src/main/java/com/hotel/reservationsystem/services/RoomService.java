package com.hotel.reservationsystem.services;

import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> allRooms = new ArrayList<>();

        for (Room room : this.roomRepository.getAllRooms()) {
            allRooms.add(room);
        }
        return allRooms;
    }

    public ArrayList<Room> getAllAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : this.roomRepository.getAllAvailableRooms()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Room createRoom(Room room){
        return roomRepository.addRoom(room);
    }

}
