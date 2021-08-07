package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.BranchDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.PhoneDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public interface PhoneService extends BaseService <PhoneDto,Long> {


    void save(String phone, BranchDto branchDto);
    List<PhoneDto> findPhonesByBranchId(Long id);
}
