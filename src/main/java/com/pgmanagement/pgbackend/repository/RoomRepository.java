package com.pgmanagement.pgbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgmanagement.pgbackend.entity.Room;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // JpaRepository automatically provides methods like save(), findAll(), and findById()
	
	List<Room> findByBlockName(String blockName);
    List<Room> findByBlockNameAndFloorNumber(String blockName, int floorNumber);
}