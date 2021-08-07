package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputMasterWorkDay;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MasterWorkDayService {
    MasterWorkDayDto saveMasterWorkDays(InputMasterWorkDay inputMasterWorkDay);
    List<MasterWorkDayAppDto> findBranchByIdAndDate(Long branchId, LocalDate date);
    boolean inTime(Long id, LocalDateTime startTime,LocalDateTime endTime);
    MasterWorkDayDto findByMasterWorkDayId(Long id);

}
