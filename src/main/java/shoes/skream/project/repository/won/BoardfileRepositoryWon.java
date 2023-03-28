package shoes.skream.project.repository.won;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Boardfile;

public interface BoardfileRepositoryWon extends JpaRepository<Boardfile, Long>{
    //List<Boardfile> findBy
}
