package kg.megacom.salonmaster.services.impl;

import io.swagger.models.Response;
import kg.megacom.salonmaster.controllers.Mappers.BranchMapper;
import kg.megacom.salonmaster.dao.BranchRepository;
import kg.megacom.salonmaster.exceptions.BranchNotFound;
import kg.megacom.salonmaster.models.Branch;
import kg.megacom.salonmaster.models.dto.BranchDto;
import kg.megacom.salonmaster.models.dto.PhoneDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputBranch;
import kg.megacom.salonmaster.models.dto.objects.outputs.OutputBranchesWithPhones;
import kg.megacom.salonmaster.services.BranchService;
import kg.megacom.salonmaster.services.PhoneService;
import kg.megacom.salonmaster.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
  private   BranchRepository  branchRepository;
    @Autowired
  private   SalonService salonService;
    @Autowired
    private PhoneService phoneService;


    @Override
    public BranchDto saveBranch(BranchDto branchDto) {
         Branch branch = BranchMapper.INSTANCE.toBranch(branchDto);
         branch.setActive(true);
         branch = branchRepository.save(branch);
        return BranchMapper.INSTANCE.toBranchDto(branch);
    }

    @Override
    public BranchDto findById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(()->new BranchNotFound("Филиал по такой айди не найден!"));
        return BranchMapper.INSTANCE.toBranchDto(branch);
    }
}
