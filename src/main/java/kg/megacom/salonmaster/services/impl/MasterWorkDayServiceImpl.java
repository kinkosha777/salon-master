package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.MasterWorkDayMapper;
import kg.megacom.salonmaster.dao.MasterWorkDayRepository;
import kg.megacom.salonmaster.exceptions.MasterWorkDayIdNotFound;
import kg.megacom.salonmaster.models.MasterWorkDay;
import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputMasterWorkDay;
import kg.megacom.salonmaster.services.AdminService;
import kg.megacom.salonmaster.services.BranchService;
import kg.megacom.salonmaster.services.MasterService;
import kg.megacom.salonmaster.services.MasterWorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterWorkDayServiceImpl implements MasterWorkDayService {
    @Autowired
    MasterWorkDayRepository masterWorkDayRepository;
    @Autowired
    MasterService masterService;
    @Autowired
    BranchService branchService;
    @Autowired
    AdminService adminService;

    @Override
    public MasterWorkDayDto saveMasterWorkDays(InputMasterWorkDay inputMasterWorkDay) {
        MasterWorkDayDto masterWorkDayDto = new MasterWorkDayDto();
        masterWorkDayDto.setAdmin(adminService.findById(inputMasterWorkDay.getAdminId()));
        masterWorkDayDto.setBranch(branchService.findById(inputMasterWorkDay.getBranchId()));
        masterWorkDayDto.setMaster(masterService.findByMasterId(inputMasterWorkDay.getMasterId()));
        masterWorkDayDto.setWorkDay(inputMasterWorkDay.getWorkDay());
        masterWorkDayDto.setStartTime(inputMasterWorkDay.getStartTime());
        masterWorkDayDto.setEndTime(inputMasterWorkDay.getEndTime());
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss")));
        masterWorkDayDto.setAddDate(dateTime);
        masterWorkDayDto.setEditDate(dateTime);
        System.out.println("masters"+masterWorkDayDto);
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(masterWorkDayRepository.save(MasterWorkDayMapper.INSTANCE.toMasterWorkDay(masterWorkDayDto)));
    }

    @Override
    public List<MasterWorkDayAppDto> findBranchByIdAndDate(Long branchId, LocalDate textDate) {

            List<MasterWorkDay> masterWorkDayList = masterWorkDayRepository.findAllByBranchIdAndWorkDayIs(branchId, textDate);

            List<MasterWorkDayAppDto> masterWorkDayAppDtoList = masterWorkDayList.stream().map(x-> {
            MasterWorkDayAppDto masterWorkDayAppDto = new MasterWorkDayAppDto();
            masterWorkDayAppDto.setMasterName(x.getMaster().getName());
            masterWorkDayAppDto.setMasterWorkDayId(x.getMaster().getId());
            masterWorkDayAppDto.setWorkDay(x.getWorkDay());
            masterWorkDayAppDto.setStartTime(x.getStartTime());
            masterWorkDayAppDto.setEndTime(x.getEndTime());
            return masterWorkDayAppDto;
        }).collect(Collectors.toList());
            return masterWorkDayAppDtoList;
        }

    @Override
    public boolean inTime(Long id, LocalDateTime startTime, LocalDateTime endTime) {

        return masterWorkDayRepository.existsByIdAndStartTimeIsLessThanEqualAndEndTimeGreaterThanEqual(id, startTime, endTime);
    }

    @Override
    public MasterWorkDayDto findByMasterWorkDayId(Long id) {
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(masterWorkDayRepository.findById(id).orElseThrow(()-> new MasterWorkDayIdNotFound("Рабочий день Мастера не найден!")));
    }

}
