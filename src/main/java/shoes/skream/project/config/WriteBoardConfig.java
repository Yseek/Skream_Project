package shoes.skream.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.repository.won.CategoryRepositoryWon;
import shoes.skream.project.repository.won.FileupRepositoryWon;
import shoes.skream.project.repository.won.MemberRepositoryWon;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;
import shoes.skream.project.service.won.WriteBoardService;
import shoes.skream.project.service.won.WriteBoardServiceImpl;

@Configuration
public class WriteBoardConfig {
    @Autowired
    BoardRepositoryWon boardRepositoryWon;
    @Autowired
    MemberRepositoryWon memberRepositoryWon;
    @Autowired
    CategoryRepositoryWon categoryRepositoryWon;
    @Autowired
    FileupRepositoryWon fileupRepositoryWon;
    @Autowired
    BoardfileRepositoryWon boardfileRepositoryWon;

    @Bean
    public WriteBoardService writeBoardService(){
        return new WriteBoardServiceImpl(boardRepositoryWon, memberRepositoryWon
                                , categoryRepositoryWon, fileupRepositoryWon
                                ,boardfileRepositoryWon);
    }
}
