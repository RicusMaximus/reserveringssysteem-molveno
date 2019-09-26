package com.hotel.reservationsystem.repositories;

import com.hotel.reservationsystem.models.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms(){
        return this.rooms;
    }

    public Room addRoom(Room room){
        this.rooms.add(room);
        return room;
    }
}
