package ajc.formation.alten.finalRest.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "REGION")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Region {

	@JsonView(Views.Common.class)
	@Id
	@EqualsAndHashCode.Include
	@Column(name="IDREGION")
	private Long idRegion;

	@JsonView(Views.Common.class)
	@Column(name = "NOMREGION", length = 15)
	private String nomRegion;

	@JsonView(Views.Common.class)
	@Column(name = "DATEDERNIEREMODIFICATION")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDernierModification;

	@JsonView(Views.Common.class)
	@Column(name = "REJET")
	private Integer rejet;
	
	@OneToMany(mappedBy = "region")
	private List<Agence> agences;
}
