package shoes.skream.project.controller.hoya;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shoes.skream.project.domain.Member;

@Controller
public class MemberController {
  @PostMapping("login.do")
  public String login(Member member, HttpSession session, HttpServletRequest request){
      int result = memberService.check(member.getEmail(),member.getPwd());
      if(result==YES_ID_PWD){ //로그인 성공일 때
          Member loginOkUser = memberService.getLogin(member.getEmail());
          session.setAttribute("loginOkUser", loginOkUser);
      }
      request.setAttribute("result", result);
      return "login/msg";
  }
}
