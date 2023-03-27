package shoes.skream.project.repository.yun;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Member;

public interface BoardMemberRepository extends JpaRepository<Member, String>{
	Member findByName(String name);
}
