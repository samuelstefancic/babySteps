package ajc.formation.alten.finalRest.dto;
import java.sql.Date;
import ajc.formation.alten.finalRest.entity.*;
import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;

public record PPDistributionDto (
    @JsonView(Views.Common.class)
    Long idPPDistribution,
    @JsonView(Views.Common.class)
    String nom,
    @JsonView(Views.Common.class)
    String prenom,
    @JsonView(Views.Common.class)
    String telephone1,
    @JsonView(Views.Common.class)
    String mail,
    @JsonView(Views.Common.class)
    Civilite civilite,
    @JsonView(Views.Common.class)
    Date date){}