package guru.springframework.vinpetclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.vinpetclinic.pojo.Owner;
import guru.springframework.vinpetclinic.pojo.PetType;
import guru.springframework.vinpetclinic.services.OwnerService;
import guru.springframework.vinpetclinic.services.PetService;
import guru.springframework.vinpetclinic.services.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	
	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService typeService;
	
	private final String VIEW_PETS_CREATE_OR_UPDATE_FORM =  "pets/createOrUpdatePetForm";
		
	public PetController(PetService petService, OwnerService ownerService, PetTypeService typeService) {
		this.petService = petService;
		this.ownerService = ownerService;
		this.typeService = typeService;
	}

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
    	return typeService.findAll();
    }
    
    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") int ownerId) {
    	return ownerService.findById(new Long(ownerId));
    }
    
    @ModelAttribute("owner")
    public void initOnwerBindire(WebDataBinder dataBinder) {
    	dataBinder.setDisallowedFields("id");
    }
}
