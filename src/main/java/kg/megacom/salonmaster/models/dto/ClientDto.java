package kg.megacom.salonmaster.models.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String name;
    private String phone;
    private Long pin;
}
