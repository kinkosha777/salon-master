package kg.megacom.salonmaster.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "salons")
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean active;
}
