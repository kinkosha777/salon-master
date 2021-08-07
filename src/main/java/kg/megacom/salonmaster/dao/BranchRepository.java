package kg.megacom.salonmaster.dao;

import kg.megacom.salonmaster.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    List<Branch> findByActiveTrueAndSalonId(Long id);
}
