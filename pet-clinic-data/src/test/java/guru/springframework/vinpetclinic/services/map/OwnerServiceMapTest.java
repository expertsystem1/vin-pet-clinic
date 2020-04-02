package guru.springframework.vinpetclinic.services.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.vinpetclinic.pojo.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerMapService;
	final long ownerId = 1L;
	final String lastname = "Lucente";

	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerServiceMap(new PetServiceMap(), new PetTypeMapService());
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastname).build());
	}

	@Test
	void findAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}
	
	@Test
	void findById() {
		Owner owner = ownerMapService.findById(ownerId);
        long storedId = owner.getId();
		assertEquals(ownerId, storedId);
	}
	
	@Test
	void saveExistingId() {
		long id = 2L;
		Owner otherOwner = Owner.builder().id(id).build();
		Owner savedOwner = ownerMapService.save(otherOwner);
		long storedId = savedOwner.getId();
		assertEquals(id, storedId);
	}
	
	@Test
	void saveNoId() {
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void delete() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void deleteById() {
		ownerMapService.deleteById(ownerId);
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void findByLastName() {
		Owner lucente = ownerMapService.findByLastName(lastname);
        long storedId = lucente.getId();
		assertEquals(ownerId, storedId);
	}
}
