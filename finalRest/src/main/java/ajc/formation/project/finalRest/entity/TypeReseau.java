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
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TYPERESEAU")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TypeReseau  {

	@JsonView(Views.Common.class)
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "IDTYPERESEAU")
	@NotNull
	private Long idTypeReseau;

	@JsonView(Views.Common.class)
	@Column(name = "LIBELLE", length = 60)
	private String libelle;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATEDERNIEREMODIFICATION")
	private Date dateDerniereModification;

	@Column(name = "REJET")
	private Integer rejet;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "IDRESEAU",referencedColumnName="IDRESEAU", foreignKey = @ForeignKey(name = "I_FK_TYPERESEAU_RESEAU")),
		@JoinColumn(name = "IDCODEINTERNERESEAU", referencedColumnName="IDCODEINTERNERESEAU",foreignKey = @ForeignKey(name = "I_FK_TYPERESEAU_RESEAU"))
	})
	private Reseau reseau;
}
