package shoes.skream.project.service.yun;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shoes.skream.project.domain.Category;
import shoes.skream.project.dto.BoardDto;

public interface BoardServiceInterface {
	Page<BoardDto> list(Pageable pageable);
	Page<BoardDto> listByView(Pageable pageable);
	Page<BoardDto> listByRecom(Pageable pageable);
	void hitsCountUp(long seq);

	Category findCategory(int categoryId);
	List<Category> listCategories();
	Page<BoardDto> listByCategory(Category category,Pageable pageable);
	Page<BoardDto> listByCategoryOrderByView(Category category,Pageable pageable);
	Page<BoardDto> listByCategoryOrderByRecom(Category category,Pageable pageable);

	Page<BoardDto> listBySubject(String keyword, Pageable pageable);
	Page<BoardDto> listByContent(String keyword, Pageable pageable);
	Page<BoardDto> listByContentAndSubject(String keyword, String keyword2,Pageable pageable);
	Page<BoardDto> listByWirter(String keyword, Pageable pageable);
}
