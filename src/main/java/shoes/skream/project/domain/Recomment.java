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
@NoArgsConstructor
@AllArgsConstructor
public class Recomment extends RUDate{

	@Id
	private long recomment_id;
	private String reco_content;
	@ManyToOne
	@JoinColumn(name = "email")
	private Member member;
	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment comment;
}
