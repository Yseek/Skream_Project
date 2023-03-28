package shoes.skream.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

	@Column(name = "MEMBER_EMAIL")
	private String email;

	@Column(name = "board_id")
	private long boardId;
}
