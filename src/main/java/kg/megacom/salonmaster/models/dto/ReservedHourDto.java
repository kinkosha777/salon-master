package kg.megacom.salonmaster.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.salonmaster.enums.ReservedStatus;
import kg.megacom.salonmaster.models.Client;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class ReservedHourDto {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;
    private MasterWorkDayDto masterWorkDay;
    private ClientDto client;
    private ReservedStatus reservedStatus;
    private AdminDto admin;
}
