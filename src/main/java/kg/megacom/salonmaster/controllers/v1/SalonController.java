package kg.megacom.salonmaster.controllers.v1;

import kg.megacom.salonmaster.controllers.basic.BaseCrudController;
import kg.megacom.salonmaster.models.dto.SalonDto;
import kg.megacom.salonmaster.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/salon")
public class SalonController implements BaseCrudController<SalonDto,Long> {
    @Autowired
    SalonService salonService;
    @Override
    public SalonDto save(SalonDto salonDto) {
        return salonService.save(salonDto);
    }

    @Override
    public SalonDto update(SalonDto salonDto) {
        return salonService.save(salonDto);
    }

    @Override
    public List<SalonDto> findAll() {
        return salonService.findAll();
    }

    @Override
    public SalonDto findById(Long id) {
        return salonService.findById(id);
    }
}
