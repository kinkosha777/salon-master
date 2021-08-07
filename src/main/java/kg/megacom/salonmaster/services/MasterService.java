package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.MasterDto;

import java.util.List;

public interface MasterService {

    MasterDto saveMasterForWorkDays(MasterDto masterDto);
    List<MasterDto> findAllMasters();
    MasterDto findByMasterId(Long id);
}
