package com.pgmanagement.pgbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgmanagement.pgbackend.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // JpaRepository automatically provides methods like save(), findAll(), and findById()
}