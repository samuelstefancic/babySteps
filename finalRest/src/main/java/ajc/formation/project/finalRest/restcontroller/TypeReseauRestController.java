package ajc.formation.alten.finalRest.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.entity.TypeReseau;
import ajc.formation.alten.finalRest.exception.TypeReseauException;
import ajc.formation.alten.finalRest.jsonview.Views;
import ajc.formation.alten.finalRest.service.TypeReseauService;
import ajc.formation.alten.finalRest.util.CheckBindingResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/typereseau")
@CrossOrigin(origins = "*")
public class TypeReseauRestController {
    
    @Autowired
    private TypeReseauService typeReseauService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeReseauRestController.class);

    @GetMapping("/{idTypeReseau}")
    @JsonView(Views.Common.class)
    public TypeReseau getByIdTypeReseau(@PathVariable Long idTypeReseau) {
        return typeReseauService.getByIdTypeReseau(idTypeReseau);
    }

    @GetMapping("/exist/{idTypeReseau}")
    @JsonView(Views.Common.class)
    public boolean idTypeReseauExist(@PathVariable Long idTypeReseau) {
        return typeReseauService.idExist(idTypeReseau);
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getAll() {
        return typeReseauService.getAll();
    }

    @GetMapping("/number")
    public int getTotalNumberTypeReseau() {
        return typeReseauService.getTotalNumberTypeReseau();
    }

    @GetMapping("/page/{pageNumber}/{itemPerPage}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getAllInPage(@PathVariable int pageNumber, @PathVariable int itemPerPage) {
        if (pageNumber < 0 || pageNumber > typeReseauService.getAll(PageRequest.ofSize(itemPerPage)).getTotalPages()) {
            throw new TypeReseauException("Wrong Page Number");
        }
        return typeReseauService.getAll(PageRequest.of(pageNumber, itemPerPage)).getContent();
    }

    @GetMapping("/page/{libelle}/{pageNumber}/{itemPerPage}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getAllInPageWithLibelleContaining(@PathVariable String libelle, @PathVariable int pageNumber, @PathVariable int itemPerPage) {
        if (pageNumber < 0 || pageNumber > typeReseauService.getAll(PageRequest.ofSize(itemPerPage)).getTotalPages()) {
            throw new TypeReseauException("Wrong Page Number");
        }
        return typeReseauService.getByLibelleContaning(libelle, PageRequest.of(pageNumber, itemPerPage)).getContent();
    }

    @GetMapping("/page/first/{itemPerPage}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getFirstPage(@PathVariable int itemPerPage) {
        return typeReseauService.getAll(PageRequest.of(0, itemPerPage)).getContent();
    }

    @GetMapping("/page/last/{itemPerPage}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getLastPage(@PathVariable int itemPerPage) {
        int numberTotalPage = typeReseauService.getAll(PageRequest.ofSize(itemPerPage)).getTotalPages();
        return typeReseauService.getAll(PageRequest.of(numberTotalPage - 1, itemPerPage)).getContent();
    }

    @GetMapping("/page/next/{page}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getNextPage(@PathVariable Page<TypeReseau> page) {
        return typeReseauService.getNextPage(page).getContent();
    }

    @GetMapping("/page/previous/{page}")
    @JsonView(Views.Common.class)
    public List<TypeReseau> getPreviousPage(@PathVariable Page<TypeReseau> page) {
        return typeReseauService.getPreviousPage(page).getContent();
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    public TypeReseau create(@Valid @RequestBody TypeReseau typeReseau, BindingResult bindingResult) {
        CheckBindingResult.checkBindingResulHasError(bindingResult);
        return typeReseauService.create(typeReseau);
    }

    @PutMapping("/{idTypeReseau}")
    @JsonView(Views.Common.class)
    public TypeReseau update(@Valid @RequestBody TypeReseau typeReseau, BindingResult bindingResult, @PathVariable Long idTypeReseau) {
        CheckBindingResult.checkBindingResulHasError(bindingResult);
        typeReseau.setIdTypeReseau(idTypeReseau);
        return typeReseauService.update(typeReseau);
    }

    @DeleteMapping("/{idTypeReseau}")
    public void delete(@PathVariable Long idTypeReseau) {
        typeReseauService.delete(idTypeReseau);
    }
}
