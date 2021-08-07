package kg.megacom.salonmaster.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "master_work_days")
public class MasterWorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    private LocalDate workDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @CreationTimestamp
    private LocalDate addDate;
    @UpdateTimestamp
    private LocalDate editDate;
    @ManyToOne
    private Admin admin;

}
