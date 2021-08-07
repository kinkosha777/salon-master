package kg.megacom.salonmaster.models.dto.objects.outputs;

import lombok.Data;

import java.util.List;
@Data
public class OutputBranchesWithPhones {
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private List<String> phones;
}
