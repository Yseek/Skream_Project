package shoes.skream.project.domain;

import javax.persistence.Column;
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
	@Column(name = "comment_id")
	private long commentId;
	@Column(name = "co_content")
	private String coContent;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	@ManyToOne
	@JoinColumn(name="MEMBER_EMAIL")
	private Member member;
}
