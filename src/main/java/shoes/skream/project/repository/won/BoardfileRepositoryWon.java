package shoes.skream.project.repository.won;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoes.skream.project.domain.Boardfile;

public interface BoardfileRepositoryWon extends JpaRepository<Boardfile, Long>{
    @Query(value = "SELECT fileupFileId FROM Boardfile b WHERE b.boardId = :boardId")
    List<Long> findByBoardId(@Param("boardId") long boardId);
}
