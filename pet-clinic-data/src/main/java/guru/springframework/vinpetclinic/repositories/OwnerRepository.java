package guru.springframework.vinpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
   Owner findByLastName(String lastName);
   List<Owner> findAllByLastNameLike(String lastName);
}
