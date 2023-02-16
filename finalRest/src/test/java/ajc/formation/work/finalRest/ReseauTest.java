package ajc.formation.alten.finalRest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ajc.formation.alten.finalRest.compositekey.ReseauKey;
import ajc.formation.alten.finalRest.entity.Reseau;
import ajc.formation.alten.finalRest.entity.TypeReseau;
import ajc.formation.alten.finalRest.service.ReseauService;
import ajc.formation.alten.finalRest.service.TypeReseauService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ReseauTest {

    @Autowired
    private ReseauService reseauService;

    @Autowired
    private TypeReseauService typeReseauService;

    @BeforeAll
    void create() {
        TypeReseau typeReseau = new TypeReseau();
        typeReseau.setIdTypeReseau(801L);
        typeReseauService.create(typeReseau);
        Reseau reseau = new Reseau();
        reseau.setReseauKey(new ReseauKey(701L, 701L));
        reseau.setDateDebut(Date.valueOf("2022-03-21"));
        Set<TypeReseau> hSet = new HashSet<TypeReseau>();
        hSet.add(typeReseauService.getByIdTypeReseau(801L));
        reseau.setTypeReseaux(hSet);
        reseauService.create(reseau);
    }

    @Test
    void createTest() {
        assertNotNull(reseauService.getByReseauKey(new ReseauKey(701L, 701L)));
    }

    @Test
    void updateTest() {
        Reseau reseau = reseauService.getByReseauKey(new ReseauKey(701L, 701L));
        reseau.setLibelle("Test");
        reseauService.update(reseau);
        assertTrue(reseauService.getByReseauKey(new ReseauKey(701L, 701L)).getLibelle().equals("Test"));
    }

    @AfterAll
    void delete() {
        reseauService.delete(new ReseauKey(701L, 701L));
        typeReseauService.delete(801L);
    }
    
}
