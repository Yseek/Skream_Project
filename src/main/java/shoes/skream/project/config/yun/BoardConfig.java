package shoes.skream.project.config.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.mapper.yun.BoardDtoMapper;
import shoes.skream.project.repository.yun.BoardRepository;
import shoes.skream.project.service.yun.BoardService;
import shoes.skream.project.service.yun.BoardServiceInterface;

@Configuration
public class BoardConfig {
	@Autowired
	BoardRepository boardRepository;

	@Autowired
	BoardDtoMapper boardDtoMapper;

	@Bean
	public BoardServiceInterface boardServiceInterface(){
		return new BoardService(boardRepository, boardDtoMapper);
	}
}
