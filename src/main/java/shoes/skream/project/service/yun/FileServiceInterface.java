package shoes.skream.project.service.yun;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;


public interface FileServiceInterface {
	Resource downloadImage(@PathVariable("fileId") Long id) throws IOException;
}
