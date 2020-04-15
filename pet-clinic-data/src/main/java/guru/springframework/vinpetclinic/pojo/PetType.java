package guru.springframework.vinpetclinic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="types")
public class PetType extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
		
	@Column(name="name")
	private String name;
	
	@Builder
	public PetType(Long id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
