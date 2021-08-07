package kg.megacom.salonmaster.controllers.v1;

import kg.megacom.salonmaster.controllers.basic.BaseCrudController;
import kg.megacom.salonmaster.models.Branch;
import kg.megacom.salonmaster.models.dto.BranchDto;
import kg.megacom.salonmaster.models.dto.objects.inputs.InputBranch;
import kg.megacom.salonmaster.models.dto.objects.outputs.OutputBranchesWithPhones;
import kg.megacom.salonmaster.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/branch")
public class BranchController  {

    @Autowired
    BranchService branchService;

    @PostMapping("/save-branch")
    public BranchDto saveBranch(@RequestBody BranchDto branchDto) {
        return branchService.saveBranch(branchDto);
    }

    @GetMapping("/findById{id}")
    public BranchDto findById(@PathVariable Long id){
        return branchService.findById(id);
    }
}
