package kg.megacom.salonmaster.models.dto.objects.inputs;

import lombok.Data;

import java.util.List;

@Data
public class InputBranch {
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private Long salonId;
    private List<String> phones;
}
