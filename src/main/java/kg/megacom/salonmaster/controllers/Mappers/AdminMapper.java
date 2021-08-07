package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.dto.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toAdmin(AdminDto adminDto);
    AdminDto toAdminDto(Admin admin);

    List<Admin> toAdmins(List<AdminDto> adminDtos);
    List<AdminDto> toAdminsDtos(List<Admin> admins);
}
