package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.SalonMapper;
import kg.megacom.salonmaster.dao.SalonRepository;
import kg.megacom.salonmaster.models.Salon;
import kg.megacom.salonmaster.models.dto.SalonDto;
import kg.megacom.salonmaster.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalonServiceImpl implements SalonService {
@Autowired
    SalonRepository salonRepository;
    @Override
    public SalonDto save(SalonDto salonDto) {
        Salon salon = SalonMapper.INSTANCE.toSalon(salonDto);
        salon = salonRepository.save(salon);
        return SalonMapper.INSTANCE.toSalonDto(salon);
    }

    @Override
    public SalonDto update(SalonDto salonDto) {
        if (!salonRepository.existsById(salonDto.getId()))
            throw new RuntimeException("Салон по айди не найден!");
        Salon salon = SalonMapper.INSTANCE.toSalon(salonDto);
        salon = salonRepository.save(salon);
        return SalonMapper.INSTANCE.toSalonDto(salon);
    }

    @Override
    public List<SalonDto> findAll() {
        return SalonMapper.INSTANCE.toSalonDtos(salonRepository.findAll());
    }

    @Override
    public SalonDto findById(Long id) {
        Salon salon = salonRepository.findById(id).orElseThrow(()->new RuntimeException("Салон по айди не найден!"));
        return SalonMapper.INSTANCE.toSalonDto(salon);
    }
}
