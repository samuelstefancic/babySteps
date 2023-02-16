package ajc.formation.alten.finalRest.entity;

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
@Table(name="LIENAGENCEVENDEUR")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LienAgenceVendeur {

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDAGENCE",referencedColumnName="IDAGENCE", foreignKey = @ForeignKey(name = "I_FK_LIENAGENCEVENDEUR_AGENCE")),
	@JoinColumn(name = "IDCODEINTERNEAGENCE", referencedColumnName="IDCODEINTERNEAGENCE",foreignKey = @ForeignKey(name = "I_FK_LIENAGENCEVENDEUR_AGENCE"))
	})
	private Agence agence;

	@ManyToOne
	@EmbeddedId
	@JoinColumns({
	@JoinColumn(name = "IDVENDEUR",referencedColumnName="IDVENDEUR", foreignKey = @ForeignKey(name = "I_FK_LIENAGENCEVENDEUR_VENDEUR")),
	@JoinColumn(name = "IDCODEINTERNEVENDEUR", referencedColumnName="IDCODEINTERNEVENDEUR",foreignKey = @ForeignKey(name = "I_FK_LIENAGENCEVENDEUR_VENDEUR"))
	})
	private Vendeur vendeur;
}
