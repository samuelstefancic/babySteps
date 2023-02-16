package ajc.formation.alten.finalRest.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LIENRESEAUREGROUPEMENT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LienReseauRegroupement {

	@Column(name="DATEDEBUT",nullable = false)
	@NotNull
	private Date dateDebut;

	@Column(name="DATEFIN")
	private Date dateFin;

	@Column(name="DATEDERNIEREMODIFICATION")
	private Date dateDerniereModification;

	@Column(name="REJET")
	private Integer rejet;

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDDISTRIBUTEUR",referencedColumnName="IDDISTRIBUTEUR", foreignKey = @ForeignKey(name = "I_FK_LIENRESEAUREGROUPEMENT_COURTIER")),
	@JoinColumn(name = "IDCODEINTERNEDISTRIBUTEUR", referencedColumnName="IDCODEINTERNEDISTRIBUTEUR",foreignKey = @ForeignKey(name = "I_FK_LIENRESEAUREGROUPEMENT_COURTIER"))
	})
	private Courtier courtier;

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDRESEAU",referencedColumnName="IDRESEAU", foreignKey = @ForeignKey(name = "I_FK_LIENRESEAUREGROUPEMENT_RESEAU")),
	@JoinColumn(name = "IDCODEINTERNERESEAU", referencedColumnName="IDCODEINTERNERESEAU",foreignKey = @ForeignKey(name = "I_FK_LIENRESEAUREGROUPEMENT_RESEAU"))
	})
	private Reseau reseau;
}
