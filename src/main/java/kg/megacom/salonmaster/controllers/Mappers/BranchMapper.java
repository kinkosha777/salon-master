package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Branch;
import kg.megacom.salonmaster.models.dto.BranchDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    Branch toBranch(BranchDto branchDto);
    BranchDto toBranchDto(Branch  branch);

    List<Branch> toBranch(List<BranchDto> branchDtos);
    List<BranchDto> toBranchDtos(List<Branch> branch);
}
