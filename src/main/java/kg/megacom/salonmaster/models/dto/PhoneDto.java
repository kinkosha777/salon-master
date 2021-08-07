package kg.megacom.salonmaster.models.dto;

import lombok.Data;
@Data
public class PhoneDto {
    private Long id;
    private String phone;
    private BranchDto branch;
}
