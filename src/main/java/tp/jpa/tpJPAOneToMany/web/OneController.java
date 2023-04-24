package tp.jpa.tpJPAOneToMany.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.jpa.tpJPAOneToMany.entites.Patient;
import tp.jpa.tpJPAOneToMany.repositories.PatientRepository;

@RestController
public class OneController {
@Autowired
PatientRepository PatientRepository;
@GetMapping("/patientsToAll")
List<Patient> patientAll(){
	
	return PatientRepository.findAll();
}

}
