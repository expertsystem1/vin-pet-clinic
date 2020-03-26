package guru.springframework.vinpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
