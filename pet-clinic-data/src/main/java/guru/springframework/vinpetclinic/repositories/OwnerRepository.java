package guru.springframework.vinpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

}
