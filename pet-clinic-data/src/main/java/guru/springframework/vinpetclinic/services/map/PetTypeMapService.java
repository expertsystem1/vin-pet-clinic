package guru.springframework.vinpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.PetType;
import guru.springframework.vinpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		if (object != null){
			return super.save(object);
		}
		return object;
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

}
