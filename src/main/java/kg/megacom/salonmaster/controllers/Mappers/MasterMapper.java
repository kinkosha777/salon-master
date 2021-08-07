package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Admin;
import kg.megacom.salonmaster.models.Master;
import kg.megacom.salonmaster.models.dto.AdminDto;
import kg.megacom.salonmaster.models.dto.MasterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterMapper {
    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);

    Master toMaster (MasterDto masterDto);
    MasterDto toMasterDto(Master master);

    List<Master> toMasters(List<MasterDto> masterDtos);
    List<MasterDto> toMasterDtos(List<Master> masters);

}
