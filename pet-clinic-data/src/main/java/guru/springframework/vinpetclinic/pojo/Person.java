package guru.springframework.vinpetclinic.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;

	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	
}
