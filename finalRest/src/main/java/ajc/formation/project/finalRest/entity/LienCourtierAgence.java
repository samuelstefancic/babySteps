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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LIENCOURTIERAGENCE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LienCourtierAgence {

	@Column(name="DATEDEBUT")
	private Date dateDebut;

	@Column(name="DATEFIN")
	private Date dateFin;

	@Column(name="DATEDERNIEREMODIFICATION")
	private Date dateDernierModification;

	@Column(name="REJET")
	private Integer Rejet;

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDDISTRIBUTEUR",referencedColumnName="IDDISTRIBUTEUR", foreignKey = @ForeignKey(name = "I_FK_LIENCOURTIERAGENCE_COURTIER")),
	@JoinColumn(name = "IDCODEINTERNEDISTRIBUTEUR", referencedColumnName="IDCODEINTERNEDISTRIBUTEUR",foreignKey = @ForeignKey(name = "I_FK_LIENCOURTIERAGENCE_COURTIER"))
	})
	private Courtier courtier;

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDAGENCE",referencedColumnName="IDAGENCE", foreignKey = @ForeignKey(name = "I_FK_LIENCOURTIERAGENCE_AGENCE")),
	@JoinColumn(name = "IDCODEINTERNEAGENCE", referencedColumnName="IDCODEINTERNEAGENCE",foreignKey = @ForeignKey(name = "I_FK_LIENCOURTIERAGENCE_AGENCE"))
	})
	private Agence agence;
}
