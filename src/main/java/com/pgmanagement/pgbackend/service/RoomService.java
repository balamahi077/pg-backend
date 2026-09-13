package com.pgmanagement.pgbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgmanagement.pgbackend.entity.Room;
import com.pgmanagement.pgbackend.repository.RoomRepository;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // Save a new room to the database
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    // Fetch all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}