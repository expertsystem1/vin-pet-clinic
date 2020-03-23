package guru.springframework.vinpetclinic.services;

import java.util.Set;

import guru.springframework.vinpetclinic.pojo.Pet;

public interface PetService {
	
	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();

}
