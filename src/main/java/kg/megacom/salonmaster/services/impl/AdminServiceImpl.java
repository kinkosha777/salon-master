package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.AdminMapper;
import kg.megacom.salonmaster.dao.AdminRepository;
import kg.megacom.salonmaster.enums.AdminStatus;
import kg.megacom.salonmaster.exceptions.AdminNotFound;
import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public AdminDto saveAdminForWorkDay(AdminDto adminDto) {
        adminDto.setAdminStatus(AdminStatus.ACTIVE);
        Admin admin = AdminMapper.INSTANCE.toAdmin(adminDto);
        admin = adminRepository.save(admin);
        return AdminMapper.INSTANCE.toAdminDto(admin);
    }

    @Override
    public AdminDto findById(Long id) {
        return AdminMapper.INSTANCE.toAdminDto(adminRepository.findById(id).orElseThrow(()-> new AdminNotFound("Админ не найден!")));
    }
}
