package kg.megacom.salonmaster.controllers;

import kg.megacom.salonmaster.models.dto.MasterWorkDayAppDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputMasterWorkDay;
import kg.megacom.salonmaster.services.MasterWorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/master-work-day")
public class MasterWorkDayController {
    @Autowired
    MasterWorkDayService masterWorkDayService;
    @PostMapping("/save-masterWorkDay")
    MasterWorkDayDto save(@RequestBody InputMasterWorkDay inputMasterWorkDay){
        return masterWorkDayService.saveMasterWorkDays(inputMasterWorkDay);

    }
    @GetMapping("/findByBranchIdAndDate")
    List<MasterWorkDayAppDto> findByBranchIdAndDate(@RequestParam Long branchId,@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate date){
        return masterWorkDayService.findBranchByIdAndDate(branchId,date);
    }
}
