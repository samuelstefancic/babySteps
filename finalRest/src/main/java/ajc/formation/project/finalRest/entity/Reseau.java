package ajc.formation.alten.finalRest.entity;

import java.sql.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.compositekey.ReseauKey;
import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="RESEAU")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class Reseau {

	@EmbeddedId
	@NotNull
	private ReseauKey reseauKey;

	@JsonView(Views.Common.class)
	@Column(name="CODEEXTERNE")
	private Integer codeExterne;

	@JsonView(Views.Common.class)
	@Column(name="LIBELLE",length = 60)
	private String libelle;

	@JsonView(Views.Common.class)
	@Column(name="DATEDEBUT",nullable = false)
	@NotNull									
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut; 

	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DATEFIN")
	private Date dateFin;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.Common.class)
	@Column(name="DATEDERNIEREMODIFICATION")
	private Date dateDerniereModification;

	@JsonView(Views.Common.class)
	@Column(name="REJET")
	private Integer rejet;

	@JsonView(Views.ReseauwithTypeReseau.class)
	@OneToMany(mappedBy = "reseau")
	@NotNull
	private Set<TypeReseau>  typeReseaux;
	
	@ManyToOne
	@JoinColumn(name="IDPPDISTRIBUTION",foreignKey =@ForeignKey(name="FK_RESEAU_PPDISTRIBUTION"))
	@JsonView(Views.ReseauWithResponsable.class)
	private PPDistribution responsable;
}
