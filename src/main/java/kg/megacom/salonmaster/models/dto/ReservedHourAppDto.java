package kg.megacom.salonmaster.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.salonmaster.enums.ReservedStatus;
import kg.megacom.salonmaster.models.Client;

import java.time.LocalDateTime;

public class ReservedHourAppDto {
    private String adminName;
    private String masterName;
    private String clientName;
    private ReservedStatus reservedStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;
}
