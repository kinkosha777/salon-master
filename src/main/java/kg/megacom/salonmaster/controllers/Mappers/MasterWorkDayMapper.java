package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.MasterWorkDay;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterWorkDayMapper {
    MasterWorkDayMapper INSTANCE = Mappers.getMapper(MasterWorkDayMapper.class);

    MasterWorkDay toMasterWorkDay(MasterWorkDayDto masterWorkDayDto);
    MasterWorkDayDto toMasterWorkDayDto(MasterWorkDay masterWorkDay);

    List<MasterWorkDay> toMasterWorkDay(List<MasterWorkDayDto> masterWorkDayDtos);
    List<MasterWorkDayAppDto> toMasterWorkDayDtos(List<MasterWorkDay> masterWorkDays);



}
