package ajc.formation.alten.finalRest.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ajc.formation.alten.finalRest.compositekey.ReseauKey;
import ajc.formation.alten.finalRest.entity.Reseau;
import ajc.formation.alten.finalRest.exception.PageException;
import ajc.formation.alten.finalRest.exception.ReseauException;
import ajc.formation.alten.finalRest.repository.ReseauRepository;
import ajc.formation.alten.finalRest.util.CheckId;
import ajc.formation.alten.finalRest.util.CheckPageable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class ReseauService {
    
    @Autowired
    private ReseauRepository reseauRepository;
    @Autowired
    private Validator validator;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReseauService.class);

    // Create
    public Reseau create(Reseau reseau) {
        checkReseauIsNotNull(reseau);
        checkConstraintViolationIsEmpty(validator.validate(reseau));
        return reseauRepository.save(reseau);
    }

    // Read
    public List<Reseau> getAll() {
        return reseauRepository.findAll();
    }

    public Reseau getByIdCodeInterneReseau(Long idCodeInterneReseau) {
        CheckId.CheckIdIsNotNull(idCodeInterneReseau);
        return reseauRepository.findByReseauKey_IdCodeInterneReseau(idCodeInterneReseau).orElseThrow(() -> {
            throw new ReseauException("Reseau not found");
        });
    }

    public Reseau getByReseauKey(ReseauKey reseauKey) {
        checkReseauKeyIsNotNull(reseauKey);
        return reseauRepository.findById(reseauKey).orElseThrow(() -> {
            throw new ReseauException("Reseau not found");
        });
    }

    public Page<Reseau> getAll(Pageable pageable) {
        CheckPageable.checkPageableIsNotNull(pageable);
        return reseauRepository.findAll(pageable);
    }

    public Page<Reseau> getNextPage(Page<Reseau> pageReseau) {
        checkPageIsNotNull(pageReseau);
        return reseauRepository.findAll(pageReseau.nextOrLastPageable());
    }

    public Page<Reseau> getPreviousPage(Page<Reseau> pageReseau) {
        checkPageIsNotNull(pageReseau);
        return reseauRepository.findAll(pageReseau.previousOrFirstPageable());
    }

    // Update
    public Reseau update(Reseau reseau) {
        checkReseauIsNotNull(reseau);
        checkReseauKeyIsNotNull(reseau.getReseauKey());
        Reseau reseauInDB = getByIdCodeInterneReseau(reseau.getReseauKey().getIdCodeInterneReseau());
        reseauInDB.setCodeExterne(reseau.getCodeExterne() == null ? reseauInDB.getCodeExterne() : reseau.getCodeExterne());
        reseauInDB.setLibelle(reseau.getLibelle() == null || reseau.getLibelle().isEmpty() ? reseauInDB.getLibelle() : reseau.getLibelle());
        reseauInDB.setDateDebut(reseau.getDateDebut() == null ? reseauInDB.getDateDebut() : reseau.getDateDebut());
        reseauInDB.setDateFin(reseau.getDateFin() == null ? reseauInDB.getDateFin() : reseau.getDateFin());
        reseauInDB.setDateDerniereModification(reseau.getDateDerniereModification() == null ? reseauInDB.getDateDerniereModification() : reseau.getDateDerniereModification());
        reseauInDB.setRejet(reseau.getRejet() == null ? reseauInDB.getRejet() : reseau.getRejet());
        reseauInDB.setTypeReseaux(reseau.getTypeReseaux() == null ? reseauInDB.getTypeReseaux() : reseau.getTypeReseaux());
        reseauInDB.setResponsable(reseau.getResponsable() == null ? reseauInDB.getResponsable() : reseau.getResponsable());
        return reseauRepository.save(reseauInDB);
    }

    // Delete
    public void delete(Reseau reseau) {
        checkReseauIsNotNull(reseau);
        deleteByReseau(reseau);
    }

    public void delete(ReseauKey reseauKey) {
        deleteByReseau(getByReseauKey(reseauKey));
    }

    public void delete(Long idCodeInterneReseau) {
        deleteByReseau(getByIdCodeInterneReseau(idCodeInterneReseau));
    }

    private void deleteByReseau(Reseau reseau) {
        reseauRepository.delete(reseau);
    }

    // Check
    private void checkReseauIsNotNull(Reseau reseau) {
        if (reseau == null) {
            throw new ReseauException("Reseau null");
        }
    }

    private void checkConstraintViolationIsEmpty(Set<ConstraintViolation<Reseau>> violations) {
        if (!violations.isEmpty()) {
            violations.forEach(v -> {
                LOGGER.debug(v.toString());
            });
            throw new ReseauException("Reseau ConstraintViolation");
        }
    }

    private void checkPageIsNotNull(Page<Reseau> pageReseau) {
        if (pageReseau == null) {
            throw new PageException();
        }
    }

    private void checkReseauKeyIsNotNull(ReseauKey reseauKey) {
        if (reseauKey == null) {
            throw new ReseauException("ReseauKey is null");
        }
    }
}
