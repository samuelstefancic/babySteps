package ajc.formation.work.finalRest.compositekey;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.jsonview.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReseauKey implements Serializable{
    
	@JsonView(Views.Common.class)
	@EqualsAndHashCode.Include
	@Column(name="IDRESEAU", nullable = false)
	private Long idReseau;

	@JsonView(Views.Common.class)
	@EqualsAndHashCode.Include
    @Column(name = "IDCODEINTERNERESEAU", nullable = false)
	private Long idCodeInterneReseau;
}
