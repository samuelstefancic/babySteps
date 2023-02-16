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

import ajc.formation.alten.finalRest.entity.TypeReseau;
import ajc.formation.alten.finalRest.service.TypeReseauService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class TypeReseauTest {

    @Autowired
    private TypeReseauService typeReseauService;
    
    @BeforeAll
    void create() {
        TypeReseau typeReseau = new TypeReseau();
        typeReseau.setIdTypeReseau(701L);
        typeReseauService.create(typeReseau);
    }

    @Test
    void createTest() {
        assertNotNull(typeReseauService.getByIdTypeReseau(701L));
    }

    @Test
    void updateTest() {
        TypeReseau typeReseau = typeReseauService.getByIdTypeReseau(701L);
        typeReseau.setLibelle("test update");
        typeReseauService.update(typeReseau);
        assertTrue(typeReseauService.getByIdTypeReseau(701L).getLibelle().equals("test update"));    
    }
 
    @AfterAll
    void delete() {
        typeReseauService.delete(701L);
    }
}

