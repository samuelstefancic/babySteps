package ajc.formation.alten.finalRest.entity;

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
@Table(name = "COURTIER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@jakarta.persistence.Embeddable
public class Courtier {

	@JsonView(Views.Common.class)
	@Id
	@NotNull
	@EqualsAndHashCode.Include
	@Column(name="IDDISTRIBUTEUR")
	private Long idDistributeur;

	@JsonView(Views.Common.class)
	@Id
	@NotNull
	@EqualsAndHashCode.Include
	@Column(name="IDCODEINTERNEDISTRIBUTEUR")
	private Long idCodeInterneDistribiteur;

	@Column(name="DATEDERNIEREMODIFICATION")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.Common.class)
	private Date dateDernierModification;

	@JsonView(Views.Common.class)
	@Column(name="REJET")
	private Integer rejet;

	@ManyToOne
	@JoinColumn(name="IDPPDISTRIBUTION",foreignKey =@ForeignKey(name="I_FK_COURTIER_PPDISTRIBUTION"))
	@NotNull
	@JsonView(Views.ReseauWithResponsable.class)
	private PPDistribution ppDistributionn;
}
