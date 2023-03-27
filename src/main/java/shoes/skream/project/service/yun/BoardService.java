package shoes.skream.project.service.yun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Category;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.mapper.yun.BoardDtoMapper;
import shoes.skream.project.repository.yun.BoardRepository;
import shoes.skream.project.repository.yun.CategoryRepository;
import shoes.skream.project.repository.yun.MemberRepository;

public class BoardService implements BoardServiceInterface {

	@Autowired
	private final BoardRepository boardRepository;

	@Autowired
	private final CategoryRepository categoryRepository;

	@Autowired
	private final BoardDtoMapper boardDtoMapper;

	@Autowired
	private final MemberRepository memberRepository;

	public BoardService(BoardRepository boardRepository, BoardDtoMapper boardDtoMapper,
			CategoryRepository categoryRepository, MemberRepository memberRepository) {
		this.boardRepository = boardRepository;
		this.boardDtoMapper = boardDtoMapper;
		this.categoryRepository = categoryRepository;
		this.memberRepository = memberRepository;
	}

	@Override
	public Page<BoardDto> list(Pageable pageable) {
		return boardRepository.findAll(pageable).map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByView(Pageable pageable) {
		return boardRepository.findAllByOrderByHitsDesc(pageable).map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByRecom(Pageable pageable) {
		return boardRepository.findAllByOrderByRecomDesc(pageable).map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public void hitsCountUp(long seq) {
		Board board = boardRepository.findById(seq).get();
		board.setHits(board.getHits() + 1);
		boardRepository.save(board);
	}

	@Override
	public Category findCategory(int categoryId) {
		return categoryRepository.findByCategoryId(categoryId);
	}

	@Override
	public Page<BoardDto> listByCategory(Category category, Pageable pageable) {
		return boardRepository.findAllByCategory(category, pageable).map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByCategoryOrderByView(Category category, Pageable pageable) {
		return boardRepository.findAllByCategoryOrderByHitsDesc(category, pageable)
				.map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByCategoryOrderByRecom(Category category, Pageable pageable) {
		return boardRepository.findAllByCategoryOrderByRecomDesc(category, pageable)
				.map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public List<Category> listCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<BoardDto> listBySubject(String keyword, Pageable pageable) {
		return boardRepository.findAllBySubjectContainingIgnoreCase(keyword, pageable)
				.map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByContent(String keyword, Pageable pageable) {
		return boardRepository.findAllByContentContainingIgnoreCase(keyword, pageable)
				.map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByContentAndSubject(String keyword, String keyword2, Pageable pageable) {
		return boardRepository
				.findByContentContainingIgnoreCaseOrSubjectContainingIgnoreCase(keyword, keyword2, pageable)
				.map(board -> BoardDto.from(board, boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByWirter(String keyword, Pageable pageable) {
		return boardRepository.findByMember(memberRepository.findByName(keyword), pageable).map(board->BoardDto.from(board, boardDtoMapper));
	}
}
