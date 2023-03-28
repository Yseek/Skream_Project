package shoes.skream.project.repository.won;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoes.skream.project.domain.Fileup;

public interface FileupRepositoryWon extends JpaRepository<Fileup, Long>{
    // @Query(value = "SELECT * FROM Fileup WHERE fileId IN (:fileIdList)", nativeQuery = true)
    @Query(value = "SELECT * FROM Fileup WHERE file_id IN (:fileIdList)", nativeQuery = true)
    List<Fileup> findByFileId(@Param("fileIdList") List<Long> fileIdList);
}
