package shoes.skream.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Column(name = "boardfile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardfileId;

	@ManyToOne
	@JoinColumn(name = "fileup_file_id")
	private Fileup fileup;
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
}