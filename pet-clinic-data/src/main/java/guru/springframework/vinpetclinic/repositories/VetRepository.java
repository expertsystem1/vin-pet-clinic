package guru.springframework.vinpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>{

}
