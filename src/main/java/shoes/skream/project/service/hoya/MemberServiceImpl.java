package shoes.skream.project.service.hoya;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {
  @Autowired
  MemberRepository memberRepository;
  @Override
  public int check(String email, String pwd) {
      Member login = MemberRepository.findByEmail(email);
      if(login == null){
          return NO_ID;
      }else{
          String dbPwd = login.getPwd();
          if(dbPwd != null) dbPwd = dbPwd.trim();

          if(!dbPwd.equals(pwd)){
              return NO_PWD;
          }else{
              return YES_ID_PWD;
          }
      }
  }
  @Override
  public Member getLogin(String email) {
      Member login = memberRepository.findByEmail(email);
      login.setPwd("");

      return login;
  }
}
