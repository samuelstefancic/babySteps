package ajc.formation.alten.finalRest.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PARTENAIRE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Partenaire {

	@Id
	@JsonView(Views.Common.class)
	@EqualsAndHashCode.Include
	@Column(name="IDPARTENAIRE")
	private Long idPartenaire;

	@JsonView(Views.Common.class)
	@Column(precision = 38,name="IDREFERENEBANCAIRE")
	private BigDecimal idRefereneBancaire;

	@JsonView(Views.Common.class)
	@Column(precision = 38,name="IDADRESSEPOSTALE")
	private BigDecimal idAdressePostale;

	@Column(name = "CODEPARTENAIRE",length = 4)
	private String codePartenaire;

	@Column(length = 35,name = "LIBELLEPARTENAIRE")
	@JsonView(Views.Common.class)
	private String libellePartenaire;

	@JsonView(Views.Common.class)
	@Column(precision = 13,scale = 2, name = "FONDDEROULEMENT")
	private BigDecimal FoundDeroulement;

	@Column(length = 8,name="IDNOEMIE")
	@JsonView(Views.Common.class)
	private String idNoEmie;

	@JsonView(Views.Common.class)
	@Column(length = 100, name = "NOMVUE")
	private String nomVue;

	@Column(precision = 13,scale = 3,name = "ECARTMAXCOMM")
	@JsonView(Views.Common.class)
	private BigDecimal ecartMaxComm;

	@Column(length = 16,name="CODEICSSEPA")
	@JsonView(Views.Common.class)
	private String codeIcsSepa;

	@Column(length = 50,name="NOMETATEDITION")
	@JsonView(Views.Common.class)
	private String nomEtatEdition;

	@Column(length = 70,name="NOMEMETTEURSEPA")
	@JsonView(Views.Common.class)
	private String nomEmetterSepa;

	@JsonView(Views.Common.class)
	@Column(length = 10,name="ORIASPARTENAIRE")
	private String oriasPartenaire;

	@JsonView(Views.Common.class)
	@Column(length = 14,name="TELEPHONE1")
	private String telephone1;

	@Column(length = 14,name="TELEPHONE2")
	@JsonView(Views.Common.class)
	private String telephone2;

	@JsonView(Views.Common.class)
	@Column(length = 100,name = "MAILPARTENAIRE")
	private String mailPartenaire;

	@JsonView(Views.Common.class)
	@Column(length = 14,name = "FAXPARTENAIRE")
	private String faxPartenaire;

	@JsonView(Views.Common.class)
	@Column(length = 50,name = "SOCIETECOMPTABLE")
	private String societeComptable;

	@JsonView(Views.Common.class)
	@Column(precision  = 1,name="INDICATEURCALCULCOMM")
	private BigDecimal indicateurCalculComm;

	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DATEDERNIEREMODIFICATION")
	private Date dateDernierModification;
	
	@JsonView(Views.Common.class)
	@Column(name="REJET")
	private Integer rejet;
}
