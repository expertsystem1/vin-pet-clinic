package guru.springframework.vinpetclinic.bootstrap;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.vinpetclinic.pojo.Owner;
import guru.springframework.vinpetclinic.pojo.Pet;
import guru.springframework.vinpetclinic.pojo.PetType;
import guru.springframework.vinpetclinic.pojo.Vet;
import guru.springframework.vinpetclinic.services.OwnerService;
import guru.springframework.vinpetclinic.services.PetService;
import guru.springframework.vinpetclinic.services.PetTypeService;
import guru.springframework.vinpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
		

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,PetService petService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		petTypeService.save(cat);
		
		PetType parrot = new PetType();
		parrot.setName("Parrot");
		petTypeService.save(parrot);
		
		Pet fido = new Pet();
		fido.setName("Fido");
		fido.setPetType(dog);
		fido.setBirthDate(LocalDate.of(2014, Month.JANUARY, 1));	
		
		Pet tom = new Pet();
		tom.setName("Tom");
		tom.setPetType(cat);
		fido.setBirthDate(LocalDate.of(2015, Month.FEBRUARY, 3));	
		
		Pet cocorito = new Pet();
		cocorito.setName("Cocorito");
		cocorito.setPetType(parrot);
		fido.setBirthDate(LocalDate.of(2016, Month.JUNE, 26));	
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setCity("Bari");
		owner1.setTelephone("+39 080 551 7254");
		owner1.setAddress("Via Dei Mille n.21 70010");
		
		Set<Pet> owner1Pets = new HashSet<Pet>();
		owner1Pets.add(fido);
		owner1Pets.add(cocorito);
		owner1.setPets(owner1Pets);
		fido.setOwner(owner1);
		cocorito.setOwner(owner1);
		ownerService.save(owner1);
				
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleannane");
		owner1.setCity("Zurich");
		owner1.setTelephone("+41 254 258 11");
		owner1.setAddress("St. Jackob Strasse n.39 8004");
			
		Set<Pet> owner2Pets = new HashSet<Pet>();
		owner2Pets.add(tom);
		owner1.setPets(owner2Pets);
		tom.setOwner(owner2);
		ownerService.save(owner2);
		
		/*petService.save(cocorito);
		petService.save(tom);
		petService.save(fido);*/
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Naomi");
		vet2.setLastName("Campbell");
		vetService.save(vet2);
		System.out.println("Loaded Owners....");
		System.out.println("Loaded Vets....");
		System.out.println("Loaded Pet's types....");
		System.out.println("Loaded Pets....");
		
	}

}
