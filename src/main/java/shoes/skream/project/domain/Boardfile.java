package shoes.skream.project.domain;

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
public class Boardfile {
	@Id
	private long boardfile_id;
	@ManyToOne
	@JoinColumn(name = "file_id")
	private Fileup fileup;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
}
