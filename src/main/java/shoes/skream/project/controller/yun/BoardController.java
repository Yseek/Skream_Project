package shoes.skream.project.controller.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shoes.skream.project.domain.Category;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.service.yun.BoardServiceInterface;

@Controller
public class BoardController {

	@Autowired
	BoardServiceInterface boardServiceInterface;

	@GetMapping("content")
	public String content(Model model, long seq, @RequestParam(required = false, defaultValue = "") String orderby,
			@PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		boardServiceInterface.hitsCountUp(seq); // 조회수 증가
		if (orderby.equals("hits")) {
			Page<BoardDto> list = boardServiceInterface.listByView(pageable);
			int nowPage = list.getPageable().getPageNumber() + 1;
			int startPage = Math.max(nowPage - 4, 1);
			int endPage = Math.min(nowPage + 4, list.getTotalPages());
			if (endPage < 10) {
				endPage = Math.min(10, list.getTotalPages());
			}
			if (endPage - startPage < 10) {
				startPage = Math.max(endPage - 9, 1);
			}
			int size = list.getPageable().getPageSize();
			model.addAttribute("orderby", orderby);
			model.addAttribute("seq", seq);
			model.addAttribute("list", list);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("size", size);
			model.addAttribute("total", list.getTotalPages());
			return "content";
		} else if (orderby.equals("recom")) {
			Page<BoardDto> list = boardServiceInterface.listByRecom(pageable);
			int nowPage = list.getPageable().getPageNumber() + 1;
			int startPage = Math.max(nowPage - 4, 1);
			int endPage = Math.min(nowPage + 4, list.getTotalPages());
			if (endPage < 10) {
				endPage = Math.min(10, list.getTotalPages());
			}
			if (endPage - startPage < 10) {
				startPage = Math.max(endPage - 9, 1);
			}
			int size = list.getPageable().getPageSize();
			model.addAttribute("orderby", orderby);
			model.addAttribute("seq", seq);
			model.addAttribute("list", list);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("size", size);
			model.addAttribute("total", list.getTotalPages());
			return "content";
		} else {
			Page<BoardDto> list = boardServiceInterface.list(pageable);
			int nowPage = list.getPageable().getPageNumber() + 1;
			int startPage = Math.max(nowPage - 4, 1);
			int endPage = Math.min(nowPage + 4, list.getTotalPages());
			if (endPage < 10) {
				endPage = Math.min(10, list.getTotalPages());
			}
			if (endPage - startPage < 10) {
				startPage = Math.max(endPage - 9, 1);
			}
			int size = list.getPageable().getPageSize();
			model.addAttribute("orderby", orderby);
			model.addAttribute("seq", seq);
			model.addAttribute("list", list);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("size", size);
			model.addAttribute("total", list.getTotalPages());
			return "content";
		}

	}

	@GetMapping("board")
	public String board_new(Model model, @RequestParam(required = false, defaultValue = "") String orderby,
			@RequestParam(value = "cate", required = false, defaultValue = "0") Integer categoryId,
			@PageableDefault(page = 0, size = 1, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		if (categoryId == 0) {
			if (orderby.equals("hits")) {
				Page<BoardDto> list = boardServiceInterface.listByView(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else if (orderby.equals("recom")) {
				Page<BoardDto> list = boardServiceInterface.listByRecom(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else {
				Page<BoardDto> list = boardServiceInterface.list(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			}
		} else {
			Category category = boardServiceInterface.findCategory(categoryId);
			if (orderby.equals("hits")) {
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByView(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else if (orderby.equals("recom")) {
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByRecom(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else {
				Page<BoardDto> list = boardServiceInterface.listByCategory(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int startPage = Math.max(nowPage - 4, 1);
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (endPage < 10) {
					endPage = Math.min(10, list.getTotalPages());
				}
				if (endPage - startPage < 10) {
					startPage = Math.max(endPage - 9, 1);
				}
				int size = list.getPageable().getPageSize();
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			}
		}
	}
}
