package ajc.formation.alten.finalRest.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.finalRest.entity.TypeReseau;

public interface TypeReseauRepository extends JpaRepository<TypeReseau, Long> {

    Optional<TypeReseau> findByIdTypeReseau(Long idTypeReseau);

    Page<TypeReseau> findByLibelleContaining(String libelle, Pageable pageable);
}
