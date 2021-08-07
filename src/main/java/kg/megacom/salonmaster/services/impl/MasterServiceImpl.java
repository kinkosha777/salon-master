package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.MasterMapper;
import kg.megacom.salonmaster.controllers.Mappers.MasterWorkDayMapper;
import kg.megacom.salonmaster.dao.MasterRepository;
import kg.megacom.salonmaster.exceptions.MasterNotFound;
import kg.megacom.salonmaster.models.Master;
import kg.megacom.salonmaster.models.dto.MasterDto;
import kg.megacom.salonmaster.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    MasterRepository masterRepository;
    @Override
    public MasterDto saveMasterForWorkDays(MasterDto masterDto) {
        Master master = MasterMapper.INSTANCE.toMaster(masterDto);
        master = masterRepository.save(master);
        return MasterMapper.INSTANCE.toMasterDto(master);
    }

    @Override
    public List<MasterDto> findAllMasters() {
        return MasterMapper.INSTANCE.toMasterDtos(masterRepository.findAll());
    }

    @Override
    public MasterDto findByMasterId(Long id) {
        Master master = masterRepository.findById(id).orElseThrow(()->new MasterNotFound("Мастер не найден!"));
        return MasterMapper.INSTANCE.toMasterDto(master);
    }
}
