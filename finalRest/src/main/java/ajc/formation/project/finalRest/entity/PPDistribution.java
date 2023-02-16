package ajc.formation.alten.finalRest.entity;

import java.sql.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PPDISTRIBUTION")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PPDistribution {

	@Id
	@EqualsAndHashCode.Include
	@JsonView(Views.Common.class)
	@Column(name="IDPPDISTRIBUTION")
	private Long idPPDistribution;

	@JsonView(Views.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "CIVILITE")
	private Civilite civilite;

	@Column(length = 40, nullable = false,name="NOM")
	@NotBlank
	@JsonView(Views.Common.class)
	private String nom;

	@JsonView(Views.Common.class)
	@Column(length = 40,name="PRENOM")
	private String prenom;

	@JsonView(Views.Common.class)
	@Column(length = 14,name="TELEPHONE1")
	private String telephone1;

	@JsonView(Views.Common.class)
	@Column(length = 14, name="TELEPHONE2")
	private String telephone2;

	@JsonView(Views.Common.class)
	@Column(length = 100, name = "MAIL")
	private String mail;

	@JsonView(Views.Common.class)
	@Column(length = 14,name="FAX")
	private String fax;

	@Column(name="DATEDERNIEREMODIFICATION")
	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDernierModification;

	@JsonView(Views.Common.class)
	@Column(name="REJET")
	private Integer rejet;

	@OneToMany(mappedBy = "responsable")
	private Set<Reseau>  reseaux;

	@OneToMany(mappedBy = "ppDistributionn")
	private Set<Courtier> courtiers;

	@OneToMany(mappedBy = "distributionWithAgence")
	private Set<Agence> agenceWithdistributions;
}
