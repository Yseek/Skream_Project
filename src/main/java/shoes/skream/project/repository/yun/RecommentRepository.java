package shoes.skream.project.repository.yun;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Recomment;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {

}
