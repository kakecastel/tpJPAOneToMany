package tp.jpa.tpJPAOneToMany.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nom;
@Temporal(TemporalType.DATE)
private Date dateNaissance ;
private boolean malade;
@OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Collection<RendezVous> rendezVous;


}
