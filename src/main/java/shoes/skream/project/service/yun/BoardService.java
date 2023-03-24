package shoes.skream.project.service.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.mapper.yun.BoardDtoMapper;
import shoes.skream.project.repository.yun.BoardRepository;

public class BoardService implements BoardServiceInterface{
	
	@Autowired
	private final BoardRepository boardRepository;

	@Autowired
	private final  BoardDtoMapper boardDtoMapper;

	public BoardService(BoardRepository boardRepository, BoardDtoMapper boardDtoMapper) {
		this.boardRepository = boardRepository;
		this.boardDtoMapper = boardDtoMapper;
	}

	@Override
	public Page<BoardDto> list(Pageable pageable) {
		return boardRepository.findAll(pageable).map(board-> BoardDto.from(board,boardDtoMapper));
	}

	@Override
	public Page<BoardDto> listByView(Pageable pageable) {
		return boardRepository.findAll(pageable).map(board -> BoardDto.from(board, boardDtoMapper));
	}
}
