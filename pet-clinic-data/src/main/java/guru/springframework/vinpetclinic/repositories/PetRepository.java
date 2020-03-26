package guru.springframework.vinpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
