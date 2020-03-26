package guru.springframework.vinpetclinic.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

@MappedSuperclass
public class Person extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
