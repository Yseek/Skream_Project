package shoes.skream.project.config.won;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.repository.won.WriteBoardRepository;
import shoes.skream.project.service.won.WriteBoardService;
import shoes.skream.project.service.won.WriteBoardServiceImpl;

@Configuration
public class WriteBoardConfig {
    @Autowired
    WriteBoardRepository repository;

    @Bean
    public WriteBoardService writeBoardService(){
        return new WriteBoardServiceImpl(repository);
    }
}
