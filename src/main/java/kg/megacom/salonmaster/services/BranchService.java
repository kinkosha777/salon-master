package kg.megacom.salonmaster.services;

import io.swagger.models.Response;
import kg.megacom.salonmaster.models.dto.BranchDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputBranch;
import kg.megacom.salonmaster.models.dto.objects.outputs.OutputBranchesWithPhones;

import java.util.List;

public interface BranchService  {
    BranchDto saveBranch(BranchDto branchDto);
//    BranchDto createAndSaveBranch(InputBranch inputBranch);
//    List<OutputBranchesWithPhones> findALlBranchesWithPhones(Long id);
    BranchDto findById(Long id);
}
