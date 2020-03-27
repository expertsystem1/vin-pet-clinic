package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Pet;
import guru.springframework.vinpetclinic.repositories.PetRepository;
import guru.springframework.vinpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetServiceJpa implements PetService {

	private final PetRepository petRepository;

	public PetServiceJpa(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<Pet>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
	
	
}
