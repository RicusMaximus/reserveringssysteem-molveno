package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public List<Room> getAllRooms(){
        return this.roomService.getAllRooms();
    }

    @GetMapping("/available")
    public List<Room> getAllAvailableRooms(){
        return this.roomService.getAllAvailableRooms();
    }

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room){
       return this.roomService.createRoom(room);
    }

}


