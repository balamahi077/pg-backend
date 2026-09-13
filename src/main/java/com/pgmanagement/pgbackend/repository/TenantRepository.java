package com.pgmanagement.pgbackend.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgmanagement.pgbackend.entity.Tenant;
import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    
    // We can define custom search methods just by naming them correctly!
    // This will automatically find all tenants assigned to a specific room.
    List<Tenant> findByRoomId(Long roomId);
}