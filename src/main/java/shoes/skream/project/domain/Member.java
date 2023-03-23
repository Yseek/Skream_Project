package shoes.skream.project.domain;

import java.util.Date;

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
public class Member extends RUDate{
	@Id
	private String email;
	private String name;
	private Date birth;
	private String phone;
	private String pwd;
}
