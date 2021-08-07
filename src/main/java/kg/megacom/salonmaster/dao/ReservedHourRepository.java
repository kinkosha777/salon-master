package kg.megacom.salonmaster.dao;

import kg.megacom.salonmaster.models.ReservedHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedHourRepository extends JpaRepository<ReservedHour,Long> {
    List<ReservedHour> findAllByMasterWorkDayId(Long masterWorkDayId);
}
