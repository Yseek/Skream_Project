package shoes.skream.project.dto.hoya;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String email;
    private String pwd;
    private String checkPwd;
    private String name;
    private Date birth;
    private String phone;
}