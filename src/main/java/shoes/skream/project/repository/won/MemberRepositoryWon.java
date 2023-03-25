package shoes.skream.project.repository.won;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Member;

public interface MemberRepositoryWon extends JpaRepository<Member, Long>{
    Member findByEmail(String email); 
}
