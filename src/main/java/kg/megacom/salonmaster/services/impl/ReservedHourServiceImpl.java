package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.ReservedHourMapper;
import kg.megacom.salonmaster.dao.ReservedHourRepository;
import kg.megacom.salonmaster.enums.ReservedStatus;
import kg.megacom.salonmaster.models.ReservedHour;
import kg.megacom.salonmaster.models.dto.ReservedHourDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputReservedHour;
import kg.megacom.salonmaster.services.AdminService;
import kg.megacom.salonmaster.services.ClientService;
import kg.megacom.salonmaster.services.MasterWorkDayService;
import kg.megacom.salonmaster.services.ReservedHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservedHourServiceImpl implements ReservedHourService {
    @Autowired
  private   ReservedHourRepository reservedHourRepository;
    @Autowired
  private   MasterWorkDayService masterWorkDayService;
    @Autowired
   private AdminService adminService;
    @Autowired
   private ClientService clientService;



//    @Override
//    public ReservedHourDto save(ReservedHourDto reservedHourDto) {
//        boolean inTime = masterWorkDayService.inTime(reservedHourDto.getMasterWorkDay().getId(), reservedHourDto.getMasterWorkDay().getStartTime(), reservedHourDto.getMasterWorkDay().getEndTime());
//        if (!inTime) {
//            throw new RuntimeException("Не входит в диапозон!");
//
//        }
//        List<ReservedHour> reservedHourList = reservedHourRepository.findAllByMasterWorkDayId(reservedHourDto.getMasterWorkDay().getId());
//        boolean isFreeTime = checkFreeTime(reservedHourList, reservedHourDto.getStartTime(), reservedHourDto.getEndTime());
//        if (isFreeTime) {
//            throw new RuntimeException("not exist free time!");
//        }
//        ReservedHour reservedHour = ReservedHourMapper.INSTANCE.toReservedHour(reservedHourDto);
//        reservedHour = reservedHourRepository.save(reservedHour);
//        return ReservedHourMapper.INSTANCE.toReservedHourDto(reservedHour);
//    }

    @Override
    public ReservedHourDto save(InputReservedHour inputReservedHour) {
        ReservedHourDto reservedHourDto = new ReservedHourDto();
        reservedHourDto.setAdmin(adminService.findById(inputReservedHour.getAdminId()));
        reservedHourDto.setClient(clientService.findByClientId(inputReservedHour.getClientId()));
        reservedHourDto.setMasterWorkDay(masterWorkDayService.findByMasterWorkDayId(inputReservedHour.getWorkDayId()));
        reservedHourDto.setStartTime(inputReservedHour.getStartTime());
        reservedHourDto.setEndTime(inputReservedHour.getEndTime());
        reservedHourDto.setReservedStatus(ReservedStatus.NEW);
        boolean inTime = masterWorkDayService.inTime(reservedHourDto.getMasterWorkDay().getId(), reservedHourDto.getMasterWorkDay().getStartTime(), reservedHourDto.getMasterWorkDay().getEndTime());
        if (!inTime) {
            throw new RuntimeException("Не входит в диапозон!");

        }
        List<ReservedHour> reservedHourList = reservedHourRepository.findAllByMasterWorkDayId(reservedHourDto.getMasterWorkDay().getId());
        boolean isFreeTime = checkFreeTime(reservedHourList, reservedHourDto.getStartTime(), reservedHourDto.getEndTime());
        if (isFreeTime) {
            throw new RuntimeException("not exist free time!");
        }
        ReservedHour reservedHour = ReservedHourMapper.INSTANCE.toReservedHour(reservedHourDto);
        reservedHour = reservedHourRepository.save(reservedHour);
        return ReservedHourMapper.INSTANCE.toReservedHourDto(reservedHour);

    }

    @Override
    public List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId) {

        List<ReservedHour> reservedHoursList = reservedHourRepository.findAllByMasterWorkDayId(masterWorkDayId);
        return ReservedHourMapper.INSTANCE.toReservedHourDtos(reservedHoursList);
    }

    private boolean checkFreeTime(List<ReservedHour> reservedHoursList, LocalDateTime startTime, LocalDateTime endTime) {
        return reservedHoursList.stream().anyMatch(x ->
                (x.getStartTime().isEqual(startTime) || x.getEndTime().isEqual(endTime))
                        ||
                        (x.getStartTime().isBefore(startTime) && x.getEndTime().isAfter(endTime))
                        ||
                        (x.getStartTime().isAfter(startTime) && x.getEndTime().isBefore(endTime))

        );


    }

}
