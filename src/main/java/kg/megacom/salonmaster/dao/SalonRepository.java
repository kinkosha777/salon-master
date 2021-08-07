package kg.megacom.salonmaster.dao;

import kg.megacom.salonmaster.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {
}
