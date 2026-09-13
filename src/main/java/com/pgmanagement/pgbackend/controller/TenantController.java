package com.pgmanagement.pgbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pgmanagement.pgbackend.entity.Tenant;
import com.pgmanagement.pgbackend.service.TenantService;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "*")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    // POST request to add a tenant
    @PostMapping
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantService.addTenant(tenant);
    }

    // GET request to fetch all tenants
    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }
    
    // GET request to fetch tenants by a specific room ID
    @GetMapping("/room/{roomId}")
    public List<Tenant> getTenantsByRoom(@PathVariable Long roomId) {
        return tenantService.getTenantsByRoomId(roomId);
    }
}