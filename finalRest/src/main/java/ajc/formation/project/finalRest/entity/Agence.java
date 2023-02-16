package ajc.formation.alten.finalRest.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AGENCE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Agence {

	@Id
	@NotNull
	@EqualsAndHashCode.Include
	@Column(name = "IDAGENCE")
	private Long idAgence;

	@JsonView(Views.Common.class)
	@Id
	@NotNull
	@EqualsAndHashCode.Include
	@Column(name = "IDCODEINTERNEAGENCE")
	private Long codeInterneAgence;

	@Column(name="IDORGANISME")
	@JsonView(Views.Common.class)
	private Long idOrganisme;

	@JsonView(Views.Common.class)
	@Column(name="IDADRESSEPOSTALEBO", precision=38)
	private BigDecimal idAdressePostaleBO;

	@Column(name="CODEEXTERNE")
	@JsonView(Views.Common.class)
	private Integer codeExterne;

	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DATEDEBUT",nullable = false)
	@NotNull	
	private Date dateDebut;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATEFIN")
	@JsonView(Views.Common.class)
	private Date dateFin;

	@JsonView(Views.Common.class)
	@Column(name = "NOMAGENCE",length = 40)
	private String nomAgence;

	@JsonView(Views.Common.class)
	@Column(name = "NOMABREGEAGENCE", length = 25)
	private String nomAbregeAgence;

	@JsonView(Views.Common.class)
	@Column(name = "COMPTE", precision = 13)
	private BigDecimal compte;

	@JsonView(Views.Common.class)
	@Column(name = "AGENCEPARDEFAUT", precision = 1)
	private BigDecimal agenceParDefaut;

	@JsonView(Views.Common.class)
	@Column(name="LIGNE1COMMENTAIRE", length = 255)
	private String ligne1Commentaire;

	@JsonView(Views.Common.class)
	@Column(name="LIGNE2COMMENTAIRE", length = 255)
	private String ligne2Commentaire;

	@JsonView(Views.Common.class)
	@Column(name="LIGNE3COMMENTAIRE", length = 255)
	private String ligne3Commentaire;

	@JsonView(Views.Common.class)
	@Column(name="LIGNE4COMMENTAIRE", length = 255)
	private String ligne4Commentaire;
	
	@JsonView(Views.Common.class)
	@Column(name="DATEDERNIEREMODIFICATION")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDernierModification;

	@JsonView(Views.Common.class)
	@Column(name="REJET")
	private Integer rejet;

	@ManyToOne
	@JoinColumn(name="IDPPDISTRIBUTION",foreignKey =@ForeignKey(name="I_FK_AGENCE_PPDISTRIBUTION"))
	@NotNull
	private PPDistribution distributionWithAgence;

	@ManyToOne
	@JoinColumn(name="IDREGION",foreignKey =@ForeignKey(name="I_FK_AGENCE_REGION"))
	private Region region;
}