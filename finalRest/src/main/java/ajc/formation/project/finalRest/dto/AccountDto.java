package ajc.formation.alten.finalRest.dto;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.entity.AccountRole;
import ajc.formation.alten.finalRest.jsonview.Views;

public record AccountDto(
    @JsonView(Views.Common.class)
    Long idAccount,
    @JsonView(Views.Common.class)
    String login,
    @JsonView(Views.Common.class)
    AccountRole accountRole
) {}
