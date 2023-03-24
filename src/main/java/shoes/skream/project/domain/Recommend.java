package shoes.skream.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Recommend {
	@Id
	@Column(name = "recommend_id")
	private long recommendId;
	@ManyToOne
	@JoinColumn(name = "email")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
}
