package kg.megacom.salonmaster.dao;

import kg.megacom.salonmaster.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
    List<Phone> findPhonesByBranchId(Long id);


}
