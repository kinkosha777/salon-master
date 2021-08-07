package kg.megacom.salonmaster.controllers.v1;

import kg.megacom.salonmaster.controllers.basic.BaseCrudController;
import kg.megacom.salonmaster.models.dto.PhoneDto;
import kg.megacom.salonmaster.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/phone")
public class PhoneController implements BaseCrudController<PhoneDto,Long> {
    @Autowired
    PhoneService phoneService;
    @Override
    public PhoneDto save(PhoneDto phoneDto) {
        return phoneService.save(phoneDto);
    }

    @Override
    public PhoneDto update(PhoneDto phoneDto) {
        return phoneService.save(phoneDto);
    }

    @Override
    public List<PhoneDto> findAll() {
        return phoneService.findAll();
    }

    @Override
    public PhoneDto findById(Long id) {
        return phoneService.findById(id);
    }
}
