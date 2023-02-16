package ajc.formation.alten.finalRest.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ajc.formation.alten.finalRest.entity.TypeReseau;
import ajc.formation.alten.finalRest.exception.PageException;
import ajc.formation.alten.finalRest.exception.TypeReseauException;
import ajc.formation.alten.finalRest.repository.TypeReseauRepository;
import ajc.formation.alten.finalRest.util.CheckId;
import ajc.formation.alten.finalRest.util.CheckPageable;
import ajc.formation.alten.finalRest.util.CheckString;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
@Service
public class TypeReseauService {
    
    @Autowired
    private TypeReseauRepository typeReseauRepository;
    @Autowired
    private Validator validator;

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeReseauService.class);

    // Create
    public TypeReseau create(TypeReseau typeReseau) {
        checkTypeReseauIsNotNull(typeReseau);
        checkConstraintViolationIsEmpty(validator.validate(typeReseau));
        return typeReseauRepository.save(typeReseau);
    }

    // Read
    public TypeReseau getByIdTypeReseau(Long idTypeReseau) {
        CheckId.CheckIdIsNotNull(idTypeReseau);
        return typeReseauRepository.findByIdTypeReseau(idTypeReseau).orElseThrow(() -> {
            throw new TypeReseauException("TypeReseau not found");
        });
    }

    public boolean idExist(Long idTypeReseau) {
        CheckId.CheckIdIsNotNull(idTypeReseau);
        return typeReseauRepository.findById(idTypeReseau).isPresent();
    }

    public Page<TypeReseau> getAll(Pageable pageable) {
        CheckPageable.checkPageableIsNotNull(pageable);
        return typeReseauRepository.findAll(pageable);
    }

    public Page<TypeReseau> getByLibelleContaning(String libelle, Pageable pageable) {
        CheckString.checkStringIsNotNullNorEmpty(libelle);
        CheckPageable.checkPageableIsNotNull(pageable);
        return typeReseauRepository.findByLibelleContaining(libelle, pageable);
    }

    public Page<TypeReseau> getNextPage(Page<TypeReseau> pageTypeReseau) {
        checkPageIsNotNull(pageTypeReseau);
        return typeReseauRepository.findAll(pageTypeReseau.nextOrLastPageable());
    }

    public Page<TypeReseau> getPreviousPage(Page<TypeReseau> pageTypeReseau) {
        checkPageIsNotNull(pageTypeReseau);
        return typeReseauRepository.findAll(pageTypeReseau.previousOrFirstPageable());
    }

    public List<TypeReseau> getAll() {
        return typeReseauRepository.findAll();
    }

    public int getTotalNumberTypeReseau() {
        return getAll().size();
    }

    // Update
    public TypeReseau update(TypeReseau typeReseau) {
        checkTypeReseauIsNotNull(typeReseau);
        CheckId.CheckIdIsNotNull(typeReseau.getIdTypeReseau());
        TypeReseau typeReseauInDB = getByIdTypeReseau(typeReseau.getIdTypeReseau());
        typeReseauInDB.setReseau(typeReseau.getReseau() == null ? typeReseauInDB.getReseau() : typeReseau.getReseau());
        typeReseauInDB.setLibelle(typeReseau.getLibelle() == null || typeReseau.getLibelle().isEmpty() ? typeReseauInDB.getLibelle() : typeReseau.getLibelle());
        typeReseauInDB.setDateDerniereModification(typeReseau.getDateDerniereModification() == null ? typeReseauInDB.getDateDerniereModification() : typeReseau.getDateDerniereModification());
        typeReseauInDB.setRejet(typeReseau.getRejet() == null ? typeReseauInDB.getRejet() : typeReseau.getRejet());
        return typeReseauRepository.save(typeReseauInDB);
    }

    // Delete
    public void delete(Long idTypeReseau) {
        CheckId.CheckIdIsNotNull(idTypeReseau);
        deleteByTypeReseau(getByIdTypeReseau(idTypeReseau));
    }

    public void delete(TypeReseau typeReseau) {
        checkTypeReseauIsNotNull(typeReseau);
        deleteByTypeReseau(typeReseau);
    }

    private void deleteByTypeReseau(TypeReseau typeReseau) {
        typeReseauRepository.delete(typeReseau);
    }

    // Check
    private void checkConstraintViolationIsEmpty(Set<ConstraintViolation<TypeReseau>> violations) {
        if (!violations.isEmpty()) {
            violations.forEach(v -> {
                LOGGER.debug(v.toString());
            });
            throw new TypeReseauException("TypeReseau ConstraintViolation");
        }
    }

    private void checkPageIsNotNull(Page<TypeReseau> page) {
        if (page == null) {
            throw new PageException();
        }
    }

    private void checkTypeReseauIsNotNull(TypeReseau typeReseau) {
        if (typeReseau == null) {
            throw new TypeReseauException("TypeReseau null");
        }
    }
}
