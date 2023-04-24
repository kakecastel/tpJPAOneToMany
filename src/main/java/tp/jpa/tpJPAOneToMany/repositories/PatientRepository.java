package tp.jpa.tpJPAOneToMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.jpa.tpJPAOneToMany.entites.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByNom(String nom);
}
