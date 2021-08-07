package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.Salon;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.models.dto.SalonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalonMapper {
    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

    Salon toSalon(SalonDto salonDto);
    SalonDto toSalonDto(Salon salon);

    List<Salon> toSalon(List<SalonDto> salonDtos);
    List<SalonDto> toSalonDtos(List<Salon> salons);
}
