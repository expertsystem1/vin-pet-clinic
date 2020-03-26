package guru.springframework.vinpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.vinpetclinic.pojo.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
