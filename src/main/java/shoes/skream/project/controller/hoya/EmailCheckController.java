package shoes.skream.project.controller.hoya;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.repository.hoya.MemberRepository;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmailCheckController {
  private final MemberRepository memberRepository;

  @GetMapping("/user/checkEmail")
  public ResponseEntity<?> checkEmailExists(@RequestParam String email) {
      if (memberRepository.existsByEmail(email)) {
          return ResponseEntity.badRequest().body("이미 사용중인 이메일입니다");
      } else {
          return ResponseEntity.ok().build();
      }
  }

  @GetMapping("/user/checkName")
  public ResponseEntity<?> checkNameExists(@RequestParam String name) {
      if (memberRepository.existsByName(name)) {
          return ResponseEntity.badRequest().body("이미 사용중인 닉네임 입니다");
      } else {
          return ResponseEntity.ok().build();
      }
  }
}
