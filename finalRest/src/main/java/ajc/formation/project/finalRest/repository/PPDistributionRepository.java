package ajc.formation.alten.finalRest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.finalRest.entity.PPDistribution;

public interface PPDistributionRepository extends JpaRepository<PPDistribution, Long> {
    
    List<PPDistribution> findByNomContaining(String nom);

    Page<PPDistribution> findAll(Pageable pageable);

    Optional<PPDistribution> findByNom(String nom);
}
