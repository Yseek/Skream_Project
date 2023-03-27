package shoes.skream.project.repository.yun;

import org.springframework.data.jpa.repository.JpaRepository;
import shoes.skream.project.domain.Board;

public interface BoardRepository extends JpaRepository<Board, String> {
}
