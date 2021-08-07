package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.MasterWorkDayMapper;
import kg.megacom.salonmaster.controllers.Mappers.PhoneMapper;
import kg.megacom.salonmaster.dao.MasterWorkDayRepository;
import kg.megacom.salonmaster.dao.PhoneRepository;
import kg.megacom.salonmaster.models.MasterWorkDay;
import kg.megacom.salonmaster.models.Phone;
import kg.megacom.salonmaster.models.dto.BranchDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.PhoneDto;
import kg.megacom.salonmaster.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;


    @Override
    public void save(String phone, BranchDto branchDto) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhone(phone);
        phoneDto.setBranch(branchDto);
        phoneRepository.save(PhoneMapper.INSTANCE.toPhone(phoneDto));
    }

    @Override
    public List<PhoneDto> findPhonesByBranchId(Long id) {
        List<Phone> phones = phoneRepository.findPhonesByBranchId(id);
        return PhoneMapper.INSTANCE.toPhoneDtos(phones);
    }

    @Override
    public PhoneDto save(PhoneDto phoneDto) {
        return null;
    }

    @Override
    public PhoneDto update(PhoneDto phoneDto) {
        return null;
    }

    @Override
    public List<PhoneDto> findAll() {
        return null;
    }

    @Override
    public PhoneDto findById(Long id) {
        return null;
    }
}
