package tp.jpa.tpJPAOneToMany.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	//----permet d'enregistrer un type enumerer au format string
	@Enumerated(EnumType.STRING)
	private StatusRDV status;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Medecin medecin;
	@OneToOne(mappedBy = "rendezVous")
	private Consultation consultation;
}
