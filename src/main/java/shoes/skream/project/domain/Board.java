package shoes.skream.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board extends RUDate{
	@Id
	private long id;
	private String subject;
	private String content;
	private int hits;
	private int recom;
	
	@ManyToOne
	//@JoinColumn(name = "ID")
	private Category category;

}
