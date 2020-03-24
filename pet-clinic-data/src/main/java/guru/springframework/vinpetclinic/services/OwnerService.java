package guru.springframework.vinpetclinic.services;

import guru.springframework.vinpetclinic.pojo.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);

}
