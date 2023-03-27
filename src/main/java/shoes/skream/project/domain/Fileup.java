package shoes.skream.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Table(name = "FILEUP")
@Entity
public class Fileup {
	@Id
	@Column(name = "file_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileId;
	private String orgnm;
	private String savednm;
	private String savedpath;

	@Builder
	public Fileup(long fileId, String orgnm, String savednm, String savedpath) {
		this.fileId = fileId;
		this.orgnm = orgnm;
		this.savednm = savednm;
		this.savedpath = savedpath;
	}
}
