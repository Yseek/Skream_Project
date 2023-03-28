package shoes.skream.project.config.won;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;
import shoes.skream.project.service.won.UpdateBoardService;
import shoes.skream.project.service.won.UpdateBoardServiceImpl;

@Configuration
public class UpdateBoardConfig {
    @Autowired
    BoardRepositoryWon boardRepositoryWon;
    @Autowired
    BoardfileRepositoryWon boardfileRepositoryWon;

    @Bean
    public UpdateBoardService updateBoardService(){
        return new UpdateBoardServiceImpl(boardRepositoryWon, boardfileRepositoryWon);
    }
}
