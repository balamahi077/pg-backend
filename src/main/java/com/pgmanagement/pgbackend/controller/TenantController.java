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
    
    
 // Get only active tenants
    @GetMapping("/active")
    public List<Tenant> getActiveTenants() {
        return tenantService.getActiveTenants();
    }

    // Get tenants on notice
    @GetMapping("/notice")
    public List<Tenant> getTenantsOnNotice() {
        return tenantService.getTenantsOnNotice();
    }

    // Caretaker clicks "Put on Notice"
    @PutMapping("/{id}/notice")
    public Tenant putOnNotice(@PathVariable Long id, @RequestParam java.time.LocalDate noticeDate) {
        return tenantService.putOnNotice(id, noticeDate);
    }

    // Caretaker clicks "Vacate"
    @PutMapping("/{id}/vacate")
    public Tenant vacateTenant(@PathVariable Long id, @RequestParam java.time.LocalDate vacateDate) {
        return tenantService.vacateTenant(id, vacateDate);
    }
    
 // Caretaker clicks "Cancel Notice"
    @PutMapping("/{id}/cancel-notice")
    public Tenant cancelNotice(@PathVariable Long id) {
        return tenantService.cancelNotice(id);
    }
}