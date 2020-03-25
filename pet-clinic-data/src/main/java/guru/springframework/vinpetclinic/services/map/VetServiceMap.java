package guru.springframework.vinpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Vet;
import guru.springframework.vinpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			super.save(object);
		}
		return object;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
