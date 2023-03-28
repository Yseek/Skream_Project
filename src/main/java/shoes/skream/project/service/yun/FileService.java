package shoes.skream.project.service.yun;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.PathVariable;

import shoes.skream.project.domain.Fileup;
import shoes.skream.project.repository.yun.FileupRepository;

public class FileService implements FileServiceInterface {

	@Value("${file.dir}")
	private String fileDir;
	@Autowired
	FileupRepository fileupRepository;
	
	public FileService(String fileDir,FileupRepository fileupRepository) {
		this.fileupRepository = fileupRepository;
		this.fileDir = fileDir;
	}

	@Override
	public Resource downloadImage(@PathVariable("fileId") Long id) throws IOException {
		Fileup file = fileupRepository.findById(id).orElse(null);
		return new UrlResource("file:" + file.getSavedpath());
	}
}
