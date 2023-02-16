package ajc.formation.alten.finalRest.mapper;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import ajc.formation.alten.finalRest.dto.PPDistributionDto;
import ajc.formation.alten.finalRest.entity.PPDistribution;

@Service
public class PPDistributionDtoMapper implements Function<PPDistribution, PPDistributionDto>{

    @Override
    public PPDistributionDto apply(PPDistribution arg) {
        return new PPDistributionDto
        (arg.getIdPPDistribution(),
         arg.getNom(),
         arg.getPrenom(),
         arg.getTelephone1(),
         arg.getTelephone2(),
         arg.getCivilite(),
         arg.getDateDernierModification());
    }
    
}