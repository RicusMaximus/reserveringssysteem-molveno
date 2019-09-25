package com.hotel.reservationsystem.repositories;

import com.hotel.reservationsystem.models.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    //  add: 1 room

    public List<Room> getAllRooms(){
        return this.rooms;
    }

    public Room getRoomById(int id){
        Room roomById = null;

        for (Room room: this.rooms) {
            if(room.getRoomNumber() == id){
               roomById = room;
            }

        }
        return roomById;
    }

    public List<Room> getAllAvailableRooms(){
        List<Room> availableRooms = new ArrayList<>();

        for (Room room: this.rooms){
            if(room.isAvailable()){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

public Room addRoom(Room room){
        this.rooms.add(room);
        return room;
}

}
