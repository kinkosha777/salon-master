package kg.megacom.salonmaster.controllers;

import kg.megacom.salonmaster.models.dto.MasterDto;
import kg.megacom.salonmaster.models.dto.MasterWorkDayDto;
import kg.megacom.salonmaster.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/master")
public class MasterController {
    @Autowired
    MasterService masterService;
    @PostMapping("save-master")
    MasterDto saveMasterForWorkDays(@RequestBody MasterDto masterDto){
        return masterService.saveMasterForWorkDays(masterDto);
    }
}
