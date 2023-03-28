package shoes.skream.project.config.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shoes.skream.project.repository.yun.FileupRepository;
import shoes.skream.project.service.yun.FileService;

@Configuration
public class FileConfig {
	@Autowired
	FileupRepository fileupRepository;

	@Value("${file.dir}")
	String fileDir;

	@Bean
	public FileService fileService() {
		return new FileService(fileDir, fileupRepository);
	}
}
