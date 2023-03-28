package shoes.skream.project.repository.won;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoes.skream.project.domain.Fileup;

public interface FileupRepositoryWon extends JpaRepository<Fileup, Long>{
    @Query(value = "SELECT savedpath FROM Fileup as f WHERE f.fileId IN (:fileIdList)")
    List<String> findByFileId(@Param("fileIdList") List<Long> fileIdList);
}
