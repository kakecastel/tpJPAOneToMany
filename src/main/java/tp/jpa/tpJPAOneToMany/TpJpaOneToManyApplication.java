package tp.jpa.tpJPAOneToMany;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tp.jpa.tpJPAOneToMany.entites.Consultation;
import tp.jpa.tpJPAOneToMany.entites.Medecin;
import tp.jpa.tpJPAOneToMany.entites.Patient;
import tp.jpa.tpJPAOneToMany.entites.RendezVous;
import tp.jpa.tpJPAOneToMany.entites.StatusRDV;
import tp.jpa.tpJPAOneToMany.repositories.ConsultationRepository;
import tp.jpa.tpJPAOneToMany.repositories.MedecinRepository;
import tp.jpa.tpJPAOneToMany.repositories.PatientRepository;
import tp.jpa.tpJPAOneToMany.repositories.RendezVousRepository;
import tp.jpa.tpJPAOneToMany.service.IHospital;

@SpringBootApplication
public class TpJpaOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpJpaOneToManyApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PatientRepository patientRepository,MedecinRepository medecinRepository,
			RendezVousRepository rendezVousRepository,
			ConsultationRepository consultationRepository,
			IHospital iHospital) {
		
		return args ->{
			Stream.of("talla","tchendje","kake")
			.forEach(name->{
					Patient patient=new Patient();
					patient.setNom(name);
					patient.setDateNaissance(new Date());
					patient.setMalade(false);
					patientRepository.save(patient);
			});
			Stream.of("WilliamNew","castelNew","sylvieNew")
			.forEach(name->{
					Medecin medecin=new Medecin();
					medecin.setNom(name);
					medecin.setSpecialite(Math.random() > 0.5 ? "Cardio":"Dentiste");
					medecin.setEmail(name+"@gmail.com");
					iHospital.addMedecin(medecin);
					//medecinRepository.save(medecin);
			});
			
			Patient p=patientRepository.findByNom("talla");
			//----permet d'obtenir une valeur null si l'element n'est pas trouve
			Patient p1=patientRepository.findById(1L).orElse(null);
			Medecin medecin=medecinRepository.findByNom("sylvie");
			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDIND);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(p);
			rendezVousRepository.save(rendezVous);
			RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation    .....  .... ");
			consultationRepository.save(consultation);
		};
		
	}

}
