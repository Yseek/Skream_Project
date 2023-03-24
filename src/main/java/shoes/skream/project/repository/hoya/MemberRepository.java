package shoes.skream.project.repository.hoya;

public class MemberRepository extends JpaRepository<Member, varchar>{
  Member findByEmail(String email);
  
}
