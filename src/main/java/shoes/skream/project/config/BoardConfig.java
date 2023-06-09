package shoes.skream.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

import shoes.skream.project.mapper.yun.BoardDtoMapper;
import shoes.skream.project.repository.yun.BoardMemberRepository;
import shoes.skream.project.repository.yun.BoardRepository;
import shoes.skream.project.repository.yun.CategoryRepository;
import shoes.skream.project.repository.yun.CommentRepository;
import shoes.skream.project.repository.yun.RecommendRepository;
import shoes.skream.project.service.yun.BoardService;
import shoes.skream.project.service.yun.BoardServiceInterface;

@Configuration
public class BoardConfig {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BoardDtoMapper boardDtoMapper;

	@Autowired
	BoardMemberRepository boardMemberRepository;

	@Autowired
	CommentRepository commnRepository;

	@Autowired
	RecommendRepository recommendRepository;

	@Bean
	public BoardServiceInterface boardServiceInterface(){
		return new BoardService(boardRepository, boardDtoMapper,categoryRepository,boardMemberRepository,commnRepository,recommendRepository);
	}

	@Bean
	public PageableHandlerMethodArgumentResolverCustomizer customize() {
		return p -> {
			p.setOneIndexedParameters(true);    // 1 페이지 부터 시작
		};
	}

}
