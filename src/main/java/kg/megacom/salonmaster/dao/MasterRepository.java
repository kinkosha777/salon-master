package kg.megacom.salonmaster.dao;

import kg.megacom.salonmaster.models.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master,Long> {
}
