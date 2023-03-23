package shoes.skream.project.domain;

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
	private long boardfile_id;
	private long fileup_file_id;
	private long board_id;
}