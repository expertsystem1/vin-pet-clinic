package guru.springframework.vinpetclinic.services.map;

import java.util.Set;

import guru.springframework.vinpetclinic.pojo.Pet;
import guru.springframework.vinpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		if (object != null ) {
			return super.save(object.getId(), object);
		}
		return object;
	}

	@Override
	public 	Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
