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
    
 // Fetch only active tenants (hides vacated ones from the main dashboard)
    public List<Tenant> getActiveTenants() {
        return tenantRepository.findByStatus("ACTIVE");
    }

    // Fetch tenants who are currently on notice
    public List<Tenant> getTenantsOnNotice() {
        return tenantRepository.findByStatus("ON_NOTICE");
    }

    // Process a notice period request
    public Tenant putOnNotice(Long tenantId, java.time.LocalDate noticeDate) {
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
        tenant.setStatus("ON_NOTICE");
        tenant.setNoticeDate(noticeDate);
        return tenantRepository.save(tenant);
    }

    // Process a vacate request (frees up the room)
    public Tenant vacateTenant(Long tenantId, java.time.LocalDate vacateDate) {
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
        tenant.setStatus("VACATED");
        tenant.setVacateDate(vacateDate);
        return tenantRepository.save(tenant);
    }
    
}