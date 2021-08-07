package kg.megacom.salonmaster.controllers;

import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping
    AdminDto save(AdminDto adminDto){
        return adminService.saveAdminForWorkDay(adminDto);
    }
}
