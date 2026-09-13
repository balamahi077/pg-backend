package com.pgmanagement.pgbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgmanagement.pgbackend.entity.Tenant;
import com.pgmanagement.pgbackend.repository.TenantRepository;
import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    // Save a new tenant
    public Tenant addTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    // Fetch all tenants
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
    
    // Fetch tenants by Room ID (utilizing the custom repository method we made)
    public List<Tenant> getTenantsByRoomId(Long roomId) {
        return tenantRepository.findByRoomId(roomId);
    }
}