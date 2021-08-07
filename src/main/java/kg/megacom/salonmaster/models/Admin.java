package kg.megacom.salonmaster.models;

import kg.megacom.salonmaster.enums.AdminStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private AdminStatus adminStatus;
}
