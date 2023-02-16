package ajc.formation.alten.finalRest.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.entity.Account;
import ajc.formation.alten.finalRest.jsonview.Views;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

	@GetMapping("/api/auth")
	@JsonView(Views.Common.class)
	public Account authentication(@AuthenticationPrincipal Account compte) {
		return compte;
	}
}
