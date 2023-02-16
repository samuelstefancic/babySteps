package ajc.formation.alten.finalRest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ajc.formation.alten.finalRest.entity.PPDistribution;
import ajc.formation.alten.finalRest.service.PPDistributionService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
//@TestInstance(Lifecycle.PER_CLASS)
public class PPDistributionTest {

    @Autowired
    private PPDistributionService ppDistributionService;
 
    @BeforeAll
    void create() {
        PPDistribution item = new PPDistribution();
        item.setIdPPDistribution(600L);
        item.setNom("roger");
        ppDistributionService.create(item);
    }

    @Test
    void testOrigin() {
        assertNotNull(ppDistributionService.getByIdPPDistribution(600L));
    }

    //Fin de test
    void updateTest() {
        PPDistribution roger = new PPDistribution();
        roger.setIdPPDistribution(601L);
        roger.setNom("roger");
        ppDistributionService.update(roger);
        assertTrue(ppDistributionService.getByIdPPDistribution(600L).getNom().equals("roger"));
    }

    @Test
    void updateDeMorts() {
        PPDistribution pierre = new PPDistribution();
        pierre.setIdPPDistribution(580L);
        pierre.setNom("Londubat");
        pierre.setMail("mail@mail.com");
        pierre.setCourtiers(null);
        ppDistributionService.create(pierre);
        pierre.setPrenom("pierre");
        ppDistributionService.update(pierre);
        assertTrue(ppDistributionService.getByIdPPDistribution(580L).getPrenom().equals("pierre"));
    }

    


    @AfterAll
    void delete() {
        ppDistributionService.delete(600L);
        ppDistributionService.delete(580L);
    }
}
