package shoes.skream.project.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Recommend {
	@Id
	private long recommend_id;
	@ManyToOne
	@JoinColumn(name = "email")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "id")
	private Board board;
}
