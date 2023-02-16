package ajc.formation.alten.finalRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.finalRest.compositekey.ReseauKey;
import ajc.formation.alten.finalRest.entity.Reseau;

public interface ReseauRepository extends JpaRepository<Reseau, ReseauKey>{
    
    Optional<Reseau> findByReseauKey_IdCodeInterneReseau(Long idCodeInterneReseau);
}
