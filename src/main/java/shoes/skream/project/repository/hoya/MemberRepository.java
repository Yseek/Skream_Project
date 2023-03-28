package shoes.skream.project.repository.hoya;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import shoes.skream.project.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
  boolean existsByEmail(String email);
  boolean existsByName(String name);
  Optional<Member> findByEmail(String email);
}

