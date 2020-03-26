package guru.springframework.vinpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Specialty;
import guru.springframework.vinpetclinic.pojo.Vet;
import guru.springframework.vinpetclinic.services.SpecialtyService;
import guru.springframework.vinpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
	
	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if(object.getSpecialties() != null && object.getSpecialties().size() > 0) {
				object.getSpecialties().forEach(specialty -> {
					if (specialty.getId() == null) {
						Specialty savedSpeciality = specialtyService.save(specialty);
						specialty.setId(savedSpeciality.getId());
					}
				});
			}
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
