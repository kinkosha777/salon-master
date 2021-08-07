package kg.megacom.salonmaster.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;
    public Branch(Long id) {
        this.id = id;
    }
    public Branch(){
        
    }

}
