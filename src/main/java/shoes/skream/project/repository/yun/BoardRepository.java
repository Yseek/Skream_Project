package shoes.skream.project.repository.yun;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Category;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Page<Board> findAllByOrderByHitsDesc (Pageable pageable);
	Page<Board> findAllByOrderByRecomDesc (Pageable pageable);
	Page<Board> findAllByCategory (Category category , Pageable pageable);
	Page<Board> findAllByCategoryOrderByHitsDesc (Category category , Pageable pageable);
	Page<Board> findAllByCategoryOrderByRecomDesc (Category category , Pageable pageable);
}
