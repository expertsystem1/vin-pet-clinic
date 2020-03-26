package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.PetType;
import guru.springframework.vinpetclinic.repositories.PetTypeRepository;
import guru.springframework.vinpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJPA implements PetTypeService {

	private final PetTypeRepository typeRepository;

	public PetTypeSDJPA(PetTypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> types = new HashSet<PetType>();
		typeRepository.findAll().forEach(types::add);
		return types;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> typeOptional = typeRepository.findById(id);
		if (typeOptional.isPresent()) 
			return typeOptional.get();
		return null;
	}

	@Override
	public PetType save(PetType object) {
		return typeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		typeRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		typeRepository.deleteById(id);
	}
	
	
}
