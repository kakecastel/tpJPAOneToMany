package tp.jpa.tpJPAOneToMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.jpa.tpJPAOneToMany.entites.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	Medecin findByNom(String nom);
}
