package guru.springframework.vinpetclinic.services;

import java.util.Set;

import guru.springframework.vinpetclinic.pojo.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	Owner findById(Long id);
	Owner save(Owner owner);
	Set<Owner> findAll();

}
