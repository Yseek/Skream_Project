package shoes.skream.project.service.yun;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shoes.skream.project.dto.BoardDto;

public interface BoardServiceInterface {
	Page<BoardDto> list(Pageable pageable);
	Page<BoardDto> listByView(Pageable pageable);
}
