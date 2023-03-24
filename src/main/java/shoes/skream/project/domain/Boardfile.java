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
public class Boardfile {
	@Id
	@Column(name = "boardfile_id")
	private long boardfileId;
	@Column(name = "fileup_file_id")
	private long fileupFileId;
	@Column(name = "board_id")
	private long boardId;
}