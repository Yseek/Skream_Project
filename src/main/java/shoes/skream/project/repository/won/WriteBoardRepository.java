package shoes.skream.project.repository.won;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Board;

public interface WriteBoardRepository extends JpaRepository<Board, Long>{
   
}