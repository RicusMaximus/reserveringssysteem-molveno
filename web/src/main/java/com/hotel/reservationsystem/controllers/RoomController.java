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

    /**
     * Return a list of all rooms when initiating a GET request on the "/all" end-point
     * @return a list of all rooms
     **/
    @GetMapping("/all")
    public List<Room> getAllRooms(){
        return this.roomService.getAllRooms();
    }

    /**
     * Return a list of all available rooms when initiating a GET request on the "/available" end-point
     * @return a list of all available rooms
     **/
    @GetMapping("/available")
    public List<Room> getAllAvailableRooms(){
        return this.roomService.getAllAvailableRooms();
    }

    /**
     * Return a room based on the id parameter when initiating a GET request on the "/one/{id}" end-point
     * @param id The RoomNumber of a Room object
     * @return a room, based on the id parameter
     **/
    @GetMapping("/one/{id}")
    public Room getRoomByID(@PathVariable int id) {
        return this.roomService.getRoomById(id);
    }

    /**
     * Create a new Room by sending the request body when initiating a POST request on the "/create" end-point
     * @param room A Room object
     * @return The created Room object
     **/
    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room){
       return this.roomService.createRoom(room);
    }
}


