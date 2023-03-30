package shoes.skream.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.repository.yun.CommentRepository;
import shoes.skream.project.repository.yun.RecommentRepository;
import shoes.skream.project.service.yun.CommentsService;
import shoes.skream.project.service.yun.CommentsServiceInterface;

@Configuration
public class CommentsConfig {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	RecommentRepository recommentRepository;

	@Bean
	public CommentsServiceInterface commentsServiceInterface(CommentRepository commentRepository,
			RecommentRepository recommentRepository) {
		return new CommentsService(commentRepository, recommentRepository);
	}

}
