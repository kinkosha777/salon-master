package kg.megacom.salonmaster.models.dto;

import kg.megacom.salonmaster.enums.AdminStatus;
import lombok.Data;

@Data
public class AdminDto {
    private Long id;
    private String name;
    private String login;
    private String password;
    private AdminStatus adminStatus;
}
