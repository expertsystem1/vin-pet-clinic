package guru.springframework.vinpetclinic.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.vinpetclinic.pojo.Owner;
import guru.springframework.vinpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
	
	@Mock
	OwnerService service;
	
	@InjectMocks
	OwnerController controller;
	
	MockMvc mvc;
	
	private Set<Owner> returnedOwners;
	private long firstOwnerId = 1L;
	private long secondOwnerId = 2L;
	
	@BeforeEach
	void setUp() {
		returnedOwners = new HashSet<Owner>();
		returnedOwners.add(Owner.builder().id(firstOwnerId).build());
		returnedOwners.add(Owner.builder().id(secondOwnerId).build());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void listOwners() throws Exception {
		when(service.findAll()).thenReturn(returnedOwners);
		mvc.perform(get("/owners"))
		   .andExpect(status().isOk())
		   .andExpect(view().name("owners/index"))
		   .andExpect(model().attribute("owners", hasSize(2)));
	}
		
	@Test
	public void findOwners() throws Exception {
		mvc.perform(get("/owners/find"))
		   .andExpect(status().isOk())
		   .andExpect(view().name("notimplemented"));
	}
	
	@Test
	public void showOwner() throws Exception {
		when(service.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mvc.perform(get("/owners/123"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
	}

}
