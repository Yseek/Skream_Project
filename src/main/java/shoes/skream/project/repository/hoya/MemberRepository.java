package shoes.skream.project.repository.hoya;

import org.springframework.data.jpa.repository.JpaRepository;
import shoes.skream.project.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
  boolean existsByEmail(String email);
}

