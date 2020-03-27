package guru.springframework.vinpetclinic.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name ="owners")
public class Owner extends Person{
	
	private static final long serialVersionUID = 1L;
	@Column(name="city")
	private String city;
	@Column(name="address")
	private String address;
	@Column(name="telephon")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();
		
	
	
	public void addPet(Pet pet) {
		if(this.pets == null) {
			this.pets = new HashSet<Pet>();
		}
		this.pets.add(pet);
	}


   @Builder
	public Owner(String firstName, String lastName, String city, String address, String telephone, Set<Pet> pets) {
		super(firstName, lastName);
		this.city = city;
		this.address = address;
		this.telephone = telephone;
		this.pets = pets;
	}
   	
}
