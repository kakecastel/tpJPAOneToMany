package tp.jpa.tpJPAOneToMany.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tp.jpa.tpJPAOneToMany.entites.Medecin;
import tp.jpa.tpJPAOneToMany.repositories.MedecinRepository;
@Service
@Transactional
public class HospImpl implements IHospital{
private MedecinRepository medecinRepository;

public HospImpl(MedecinRepository medecinRepository) {
	//super();
	this.medecinRepository = medecinRepository;
}

	public Medecin addMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		return medecinRepository.save(medecin);
	}

}
