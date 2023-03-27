package shoes.skream.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	@Column(name="board_id")
	private long boardId;
	@Column(name="MEMBER_EMAIL")
	private String email;
}
