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
public class Comment extends RUDate{
	@Id
	private long comment_id;
	private String co_content;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private Member member;
}
