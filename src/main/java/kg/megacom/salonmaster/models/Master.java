package kg.megacom.salonmaster.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
