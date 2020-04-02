package guru.springframework.vinpetclinic.services.jpa;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.vinpetclinic.pojo.Owner;
import guru.springframework.vinpetclinic.repositories.OwnerRepository;


@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
	    
    @Mock
    OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerServiceJpa ownerService;
	
    private static final String LAST_NAME = "Lucente";
    private final long ownerId = 1L;
    
    Owner returnOwner;
    Set<Owner> returnedOwners;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
		returnedOwners = new HashSet<Owner>();
		returnedOwners.add(returnOwner);
	}

	@Test
	void findAll() {
		when(ownerRepository.findAll()).thenReturn(returnedOwners);
		Set<Owner> owners = ownerService.findAll();
		assertEquals(1,owners.size());
	}
	
	@Test
	void findById() {
		 when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		 Owner owner = ownerService.findById(ownerId);
		 assertNotNull(owner);
	}
	
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerService.findById(1L);
        assertNull(owner);
    }
	
	
	@Test
	void save() {
		 when(ownerRepository.save(any())).thenReturn(returnOwner);
		 Owner ownerToSave = Owner.builder().id(ownerId).build();
		 Owner owner = ownerService.save(ownerToSave);
		 assertNotNull(owner);
		 verify(ownerRepository).save(any());
	}
	
	@Test
	void delete() {
       ownerService.delete(returnOwner);
       verify(ownerRepository, times(1)).delete(any());
	}
	
	@Test
	void deleteById() {
		ownerService.deleteById(ownerId);
        verify(ownerRepository).deleteById(anyLong());
	}
	
	@Test
	void findByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner lucente = ownerService.findByLastName(LAST_NAME);
		assertEquals(lucente.getLastName(),LAST_NAME);
	}
}
