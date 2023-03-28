package shoes.skream.project.repository.yun;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Recommend;

public interface RecommendRepository extends JpaRepository<Recommend,Long>{
	Recommend findByBoardIdAndEmail(long boardId, String email);
}
