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
@NoArgsConstructor
@AllArgsConstructor
public class Recomment extends RUDate{

	@Id
	@Column(name = "recomment_id")
	private long recommentId;
	@Column(name = "reco_content")
	private String recoContent;
	@Column(name = "MEMBER_EMAIL")
	private String email;
	@Column(name = "comment_id")
	private long commentId;
}
