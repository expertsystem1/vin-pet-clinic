package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Specialty;
import guru.springframework.vinpetclinic.repositories.SpecialityRepository;
import guru.springframework.vinpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecilityServiceJpa implements SpecialtyService{

	private final SpecialityRepository specialityRepository;

	public SpecilityServiceJpa(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialities = new HashSet<Specialty>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Specialty findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialityRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}
	
	
}
