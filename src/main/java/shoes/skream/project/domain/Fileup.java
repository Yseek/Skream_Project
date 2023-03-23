package shoes.skream.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "FILEUP")
@Entity
public class Fileup {
	@Id
	private long file_id;
	private String orgnm;
	private String savednm;
	private String savedpath;

	@Builder
	public Fileup(long file_id, String orgnm, String savednm, String savedpath) {
		this.file_id = file_id;
		this.orgnm = orgnm;
		this.savednm = savednm;
		this.savedpath = savedpath;
	}
}
