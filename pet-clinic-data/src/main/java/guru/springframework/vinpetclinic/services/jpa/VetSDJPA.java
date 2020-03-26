package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Vet;
import guru.springframework.vinpetclinic.repositories.VetRepository;
import guru.springframework.vinpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJPA implements VetService{

	private final VetRepository vetRepository;

	public VetSDJPA(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> vetOptional = vetRepository.findById(id);
		if (vetOptional.isPresent()) 
			return vetOptional.get();
		return null;
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}
	
	
}
