package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.ReservedHourDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputReservedHour;

import java.util.List;

public interface ReservedHourService {

    ReservedHourDto save (InputReservedHour inputReservedHour);
    List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId);


}
