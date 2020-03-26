package guru.springframework.vinpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.vinpetclinic.pojo.Owner;
import guru.springframework.vinpetclinic.repositories.OwnerRepository;
import guru.springframework.vinpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJPA implements OwnerService{

	private final OwnerRepository ownerRepository;

	public OwnerSDJPA(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<Owner>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		this.ownerRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		this.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerRepository.findByLastName(lastName);
	}


}
