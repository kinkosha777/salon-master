package kg.megacom.salonmaster.controllers;

import kg.megacom.salonmaster.models.dto.ReservedHourDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputReservedHour;
import kg.megacom.salonmaster.services.ReservedHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reserved-hour")
public class ReservedHourController {

    @Autowired
    ReservedHourService reservedHourService;
    @PostMapping("/save-reserve")
    public ReservedHourDto save(@RequestBody InputReservedHour inputReservedHour){
        return reservedHourService.save(inputReservedHour);
    }

    @GetMapping("/getId")
    public List<ReservedHourDto> getId(@RequestParam Long masterWorkId){
        return reservedHourService.findByMasterWorkDayId(masterWorkId);
    }
}
