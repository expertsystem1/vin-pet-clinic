package guru.springframework.vinpetclinic.services;

import java.util.Set;

import guru.springframework.vinpetclinic.pojo.Vet;

public interface VetService {
	
	Vet findById(Long id);
	Vet save(Vet vet);
	Set<Vet> findAll();
	
}
