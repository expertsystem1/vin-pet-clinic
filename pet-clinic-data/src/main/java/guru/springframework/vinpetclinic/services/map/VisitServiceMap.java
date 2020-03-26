package guru.springframework.vinpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Visit;
import guru.springframework.vinpetclinic.services.VisitService;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public  Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		if(!isValidVisit(object)) {
			throw new RuntimeException("Invalid visit");
		}
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	private boolean isValidVisit(Visit object) {
		if(object.getPet() == null)
			return false;
		if(object.getPet().getOwner() == null)
			return false;
		if (object.getPet().getId() == null)
			return false;
		if(object.getPet().getOwner().getId() == null) 
			return false;
	    return true;
	}


}
