package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.AdminDto;

public interface AdminService {

    AdminDto saveAdminForWorkDay(AdminDto adminDto);
    AdminDto findById(Long id);
}
