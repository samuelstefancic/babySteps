package ajc.formation.alten.finalRest.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import ajc.formation.alten.finalRest.entity.PPDistribution;
import ajc.formation.alten.finalRest.exception.PPDistributionException;
import ajc.formation.alten.finalRest.exception.PageException;
import ajc.formation.alten.finalRest.repository.PPDistributionRepository;
import ajc.formation.alten.finalRest.util.CheckId;
import ajc.formation.alten.finalRest.util.CheckPageable;
import ajc.formation.alten.finalRest.util.CheckString;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class PPDistributionService {
    
    @Autowired
    private PPDistributionRepository ppDistributionRepository;
    @Autowired
    private Validator validator;

    private static final Logger LOGGER = LoggerFactory.getLogger(PPDistributionService.class);


    //Other 

    public String getTotalNamesPPDistribution() {
        return getAll().toString();
    }
    
    // Create
    public PPDistribution create(PPDistribution ppDistribution) {
        checkPPDistributionIsNotNull(ppDistribution);
        checkConstraintViolationIsEmpty(validator.validate(ppDistribution));
        return ppDistributionRepository.save(ppDistribution);
    }

    // Read
    public List<PPDistribution> getAll() {
        return ppDistributionRepository.findAll();
    }

    public PPDistribution getByIdPPDistribution(Long idPPDistribution) {
        CheckId.CheckIdIsNotNull(idPPDistribution);
        return ppDistributionRepository.findById(idPPDistribution).orElseThrow(() -> {
            throw new PPDistributionException("PPDistribution not found");
        });
    }

    public PPDistribution getByIdPpDistributionDto(Long item) {
        CheckId.CheckIdIsNotNull(item);
        return ppDistributionRepository.findById(item).orElseThrow(() -> {
            throw new PPDistributionException("PPDistribution not found");
        });
    }

/* 
public PPDistribution getByNameDistrib(String name) {
    CheckString.checkStringIsNotNullNorEmpty(name);
    return ppDistributionRepository.findByNom(name);
}*/

    public List<PPDistribution> getByNameContaining(String name) {
        CheckString.checkStringIsNotNullNorEmpty(name);
        return ppDistributionRepository.findByNomContaining(name);
    }

    public Page<PPDistribution> getAll(Pageable pageable) {
        CheckPageable.checkPageableIsNotNull(pageable);
        return ppDistributionRepository.findAll(pageable);
    }

    public Page<PPDistribution> getNextPage(Page<PPDistribution> page) {
        checkPageIsNotNull(page);
        return ppDistributionRepository.findAll(page.nextOrLastPageable());
    }

    public Page<PPDistribution> getPreviousPage(Page<PPDistribution> page) {
        checkPageIsNotNull(page);
        return ppDistributionRepository.findAll(page.previousOrFirstPageable());
    }

    // Update

    public PPDistribution update(PPDistribution ppDistribution) {
        checkPPDistributionIsNotNull(ppDistribution);
        CheckId.CheckIdIsNotNull(ppDistribution.getIdPPDistribution());

        PPDistribution item = getByIdPPDistribution(ppDistribution.getIdPPDistribution());

        item.setAgenceWithdistributions(ppDistribution.getAgenceWithdistributions() == null ? 
        item.getAgenceWithdistributions() : ppDistribution.getAgenceWithdistributions());

        item.setCivilite(ppDistribution.getCivilite() == null  ?
        item.getCivilite() : ppDistribution.getCivilite());

        item.setCourtiers(ppDistribution.getCourtiers() == null || ppDistribution.getCourtiers().isEmpty() ?
        item.getCourtiers() : ppDistribution.getCourtiers());

        item.setDateDernierModification(ppDistribution.getDateDernierModification() == null ?
        item.getDateDernierModification() : ppDistribution.getDateDernierModification()); 
        
        item.setFax(ppDistribution.getFax() == null || ppDistribution.getFax().isEmpty() ?
        item.getFax() : ppDistribution.getFax());

        item.setIdPPDistribution(ppDistribution.getIdPPDistribution() == null ?
        item.getIdPPDistribution() : ppDistribution.getIdPPDistribution());

        item.setMail(ppDistribution.getMail() == null || ppDistribution.getMail().isEmpty() ?
        item.getMail() : ppDistribution.getMail());

        item.setNom(ppDistribution.getNom() == null || ppDistribution.getNom().isEmpty() ? 
        item.getNom() : ppDistribution.getNom());

        item.setPrenom(ppDistribution.getPrenom() == null || ppDistribution.getPrenom().isEmpty() ? 
        item.getPrenom() : ppDistribution.getPrenom());

        item.setRejet(ppDistribution.getRejet() == null ? 
        item.getRejet() : ppDistribution.getRejet());

        item.setReseaux(ppDistribution.getReseaux() == null || ppDistribution.getReseaux().isEmpty() ? 
        item.getReseaux() : ppDistribution.getReseaux());

        item.setTelephone1(ppDistribution.getTelephone1() == null || ppDistribution.getTelephone1().isEmpty() ?
        item.getTelephone1() : ppDistribution.getTelephone1());

        item.setTelephone2(ppDistribution.getTelephone2() == null || ppDistribution.getTelephone2().isEmpty() ? 
        item.getTelephone2() : ppDistribution.getTelephone2());

        return ppDistributionRepository.save(item);

    }

    // Delete
    public void delete(Long idPPDistribution) {
        CheckId.CheckIdIsNotNull(idPPDistribution);
        deleteByPPDistribution(getByIdPPDistribution(idPPDistribution));
    }

    public void delete(PPDistribution ppDistribution) {
        checkPPDistributionIsNotNull(ppDistribution);
        deleteByPPDistribution(ppDistribution);;
    }


    private void deleteByPPDistribution(PPDistribution ppDistribution) {
        ppDistributionRepository.delete(ppDistribution);
    }

    public void deleteByName(String name) {
        CheckString.checkStringIsNotNullNorEmpty(name);
        ppDistributionRepository.delete(ppDistributionRepository.findByNom(name)
        .orElseThrow(() -> {
            throw new PPDistributionException("Name is not found");
        }));

    }


    // Check
    private void checkPPDistributionIsNotNull(PPDistribution ppDistribution) {
        if (ppDistribution == null) {
            throw new PPDistributionException("PPDistribution is null");
        }
    }

    private void checkConstraintViolationIsEmpty(Set<ConstraintViolation<PPDistribution>> violations) {
        if (!violations.isEmpty()) {
            violations.forEach(v -> {
                LOGGER.debug(v.toString());
            });
            throw new PPDistributionException("PPDistribution ConstraintViolation");
        }
    }

    private void checkPageIsNotNull(Page<PPDistribution> page) {
        if (page == null){
            throw new PageException();
        }

    }

}