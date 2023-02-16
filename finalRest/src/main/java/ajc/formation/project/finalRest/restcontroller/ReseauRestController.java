package ajc.formation.alten.finalRest.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ajc.formation.alten.finalRest.service.ReseauService;

@RestController
@RequestMapping("/api/reseau")
@CrossOrigin(origins = "*")
public class ReseauRestController {
    
    @Autowired
    private ReseauService reseauService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReseauRestController.class);

    
}
