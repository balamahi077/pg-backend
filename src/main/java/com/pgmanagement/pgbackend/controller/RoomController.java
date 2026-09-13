package com.pgmanagement.pgbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pgmanagement.pgbackend.entity.Room;
import com.pgmanagement.pgbackend.service.RoomService;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*") // Allows your future frontend to talk to this backend
public class RoomController {

    @Autowired
    private RoomService roomService;

    // POST request to create a room
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // GET request to fetch all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    
    @Autowired
    private com.pgmanagement.pgbackend.repository.RoomRepository roomRepository; // Quick autowire for the new repository methods

    @GetMapping("/block/{blockName}")
    public List<Room> getRoomsByBlock(@PathVariable String blockName) {
        return roomRepository.findByBlockName(blockName);
    }

    @GetMapping("/block/{blockName}/floor/{floorNumber}")
    public List<Room> getRoomsByFloor(@PathVariable String blockName, @PathVariable int floorNumber) {
        return roomRepository.findByBlockNameAndFloorNumber(blockName, floorNumber);
    }
}