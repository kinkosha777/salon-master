package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.ReservedHour;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.models.dto.ReservedHourDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservedHourMapper {
    ReservedHourMapper INSTANCE = Mappers.getMapper(ReservedHourMapper.class);

    ReservedHour toReservedHour(ReservedHourDto reservedHourDto);
    ReservedHourDto toReservedHourDto(ReservedHour reservedHour);

    List<ReservedHour> toReservedHour (List<ReservedHourDto> reservedHourDtos);
    List<ReservedHourDto> toReservedHourDtos(List<ReservedHour> reservedHours);
}
