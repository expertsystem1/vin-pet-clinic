package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Visit;
import guru.springframework.vinpetclinic.repositories.VisitRepository;
import guru.springframework.vinpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJPA implements VisitService{

	private final VisitRepository visitRepository;

	public VisitSDJPA(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
	
	
}
