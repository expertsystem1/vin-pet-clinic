package guru.springframework.vinpetclinic.services;

import java.util.List;

import guru.springframework.vinpetclinic.pojo.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	List<Owner> findAllByLastNameLike(String lastName);

}
