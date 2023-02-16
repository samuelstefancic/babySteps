package ajc.formation.alten.finalRest.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.dto.PPDistributionDto;
import ajc.formation.alten.finalRest.entity.PPDistribution;
import ajc.formation.alten.finalRest.service.PPDistributionService;
import ajc.formation.alten.finalRest.util.CheckBindingResult;
import jakarta.validation.Valid;
import ajc.formation.alten.finalRest.jsonview.Views;
import ajc.formation.alten.finalRest.mapper.PPDistributionDtoMapper;

@RestController
@RequestMapping("/api/ppdistribution/")
@CrossOrigin(origins = "*")
public class PPDistributionRestController {

    @Autowired
    private PPDistributionService ppDistributionService;

    @Autowired
    private PPDistributionDtoMapper ppDistributionDtoMapper;

    //Basique
    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<PPDistributionDto> getAll() {
        return ppDistributionService.getAll()
        .stream()
        .map(ppDistributionDtoMapper)
        .collect(Collectors.toList());
    }

    @GetMapping("/id/{idPPDistribution}")
    @JsonView(Views.Common.class)
    public PPDistributionDto getByIdPpDistributionDto(@PathVariable Long item) {
        return ppDistributionDtoMapper.apply(ppDistributionService.getByIdPPDistribution(item));
    }

    @GetMapping("/name")
    public String getTotalNamesPPDistribution() {
        return ppDistributionService.getTotalNamesPPDistribution();
    }

    //Post - 

    @PostMapping("")
    @JsonView(Views.Common.class)
    public PPDistributionDto userCreate(@Valid PPDistribution item, BindingResult binding) {
        CheckBindingResult.checkBindingResulHasError(binding);
        return ppDistributionDtoMapper.apply(ppDistributionService.create(item));
    }
    
    @DeleteMapping("")
    @JsonView(Views.Common.class)
    public void deleteById(@PathVariable Long id) {
        ppDistributionService.delete(id);
    }

    @DeleteMapping("/nom/{nom}")
    @JsonView(Views.Common.class)
    public void deleteByName(@PathVariable String name) {
        ppDistributionService.deleteByName(name);
    }
}