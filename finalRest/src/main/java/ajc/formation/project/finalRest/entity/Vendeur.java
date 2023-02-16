package ajc.formation.alten.finalRest.entity;

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
@Table(name = "VENDEUR")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendeur {

	@JsonView(Views.Common.class)
	@Id
	@EqualsAndHashCode.Include
	@Column(name="IDVENDEUR")
	private Long idVendeur;

	@JsonView(Views.Common.class)
	@Id
	@EqualsAndHashCode.Include
	@Column(name="IDCODEINTERNEVENDEUR")
	private Long idCodeInterneVendeur;

	@JsonView(Views.Common.class)
	@Column(name="CODE", length = 4)
	private String CodeExterne;

	@JsonView(Views.Common.class)
	@Column(name="LIBELLE",length = 60)
	private String libelle;

	@Column(name = "DATEDERNIEREMODIFICATION")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.Common.class)
	private Date dateDerniereModification;
	
	@JsonView(Views.Common.class)
	@Column(name = "REJET")
	private Integer rejet;
}
