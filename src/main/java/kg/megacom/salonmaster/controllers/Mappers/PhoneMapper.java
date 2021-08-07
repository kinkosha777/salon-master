package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.Phone;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.models.dto.PhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toPhone(PhoneDto phoneDto);
    PhoneDto toPhoneDto(Phone phone);

    List<Phone> toPhone(List<PhoneDto> phoneDtos);
    List<PhoneDto> toPhoneDtos(List<Phone> phones);
}
