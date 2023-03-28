package shoes.skream.project.controller.yun;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shoes.skream.project.domain.Category;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.dto.CommentDTO;
import shoes.skream.project.service.yun.BoardServiceInterface;
import shoes.skream.project.service.yun.FileServiceInterface;

@Controller
public class BoardController {

	@Autowired
	BoardServiceInterface boardServiceInterface;

	@Autowired
	FileServiceInterface fileServiceInterface;

	@GetMapping("content")
	public String content(Model model, long seq, @RequestParam(required = false, defaultValue = "") String orderby,
			@RequestParam(value = "cate", required = false, defaultValue = "0") Integer categoryId,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(value = "search", required = false, defaultValue = "") String searchForWhat,
			@PageableDefault(page = 0, size = 3, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		boardServiceInterface.hitsCountUp(seq); // 조회수 증가
		List<Category> categories = boardServiceInterface.listCategories();
		if (keyword.length() != 0) {
			if (searchForWhat.equals("subject")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listBySubject(keyword, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("keyword", keyword);
				model.addAttribute("seq", seq);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "제목";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else if (searchForWhat.equals("content")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByContent(keyword, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("keyword", keyword);
				model.addAttribute("seq", seq);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "내용";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else if (searchForWhat.equals("subjectAndContent")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByContentAndSubject(keyword, keyword, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("keyword", keyword);
				model.addAttribute("seq", seq);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "제목+내용";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else if (searchForWhat.equals("writer")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByWirter(keyword, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("keyword", keyword);
				model.addAttribute("seq", seq);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "작성자";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			}

		}
		if (categoryId == 0) {
			if (orderby.equals("hits")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByView(pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else if (orderby.equals("recom")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByRecom(pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.list(pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			}
		} else {
			Category category = boardServiceInterface.findCategory(categoryId);
			if (orderby.equals("hits")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByView(category, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else if (orderby.equals("recom")) {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByRecom(category, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			} else {
				BoardDto contents = boardServiceInterface.showContentById(seq);
				Page<BoardDto> list = boardServiceInterface.listByCategory(category, pageable);
				List<CommentDTO> comments = boardServiceInterface.listComment(seq);
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
				model.addAttribute("contents", contents);
				model.addAttribute("comments", comments);
				model.addAttribute("seq", seq);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "content";
			}
		}
	}

	@GetMapping("boardlist")
	public String board_new(Model model, @RequestParam(required = false, defaultValue = "") String orderby,
			@RequestParam(value = "cate", required = false, defaultValue = "0") Integer categoryId,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(value = "search", required = false, defaultValue = "") String searchForWhat,
			@PageableDefault(page = 0, size = 3, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		List<Category> categories = boardServiceInterface.listCategories();
		// 검색기능
		if (keyword.length() != 0) {
			if (searchForWhat.equals("subject")) {
				Page<BoardDto> list = boardServiceInterface.listBySubject(keyword, pageable);
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
				model.addAttribute("keyword", keyword);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "제목";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else if (searchForWhat.equals("content")) {
				Page<BoardDto> list = boardServiceInterface.listByContent(keyword, pageable);
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
				model.addAttribute("keyword", keyword);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "내용";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else if (searchForWhat.equals("subjectAndContent")) {
				Page<BoardDto> list = boardServiceInterface.listByContentAndSubject(keyword, keyword, pageable);
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
				model.addAttribute("keyword", keyword);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "제목+내용";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
				model.addAttribute("categoryId", categoryId);
				model.addAttribute("orderby", orderby);
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("size", size);
				model.addAttribute("total", list.getTotalPages());
				return "board";
			} else if (searchForWhat.equals("writer")) {
				Page<BoardDto> list = boardServiceInterface.listByWirter(keyword, pageable);
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
				model.addAttribute("keyword", keyword);
				model.addAttribute("searchForWhatVal", searchForWhat);
				searchForWhat = "작성자";
				model.addAttribute("searchForWhat", searchForWhat);
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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
				model.addAttribute("categories", categories);
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

	@GetMapping("board") // 현재 마지막페이지가 조회 할 마지막페이지 보다 클때 조회 할 페이지의 넘버 조정
	public String list_(Model model, @RequestParam(required = false, defaultValue = "") String orderby, int page,
			@RequestParam(value = "cate", required = false, defaultValue = "0") Integer categoryId,
			@PageableDefault(page = 0, size = 3, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		if (categoryId == 0) {
			if (orderby.equals("hits")) {
				Page<BoardDto> list = boardServiceInterface.listByView(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page + "&orderby=" + orderby;
			} else if (orderby.equals("recom")) {
				Page<BoardDto> list = boardServiceInterface.listByRecom(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page + "&orderby=" + orderby;
			} else {
				Page<BoardDto> list = boardServiceInterface.list(pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page;
			}
		} else {
			Category category = boardServiceInterface.findCategory(categoryId);
			if (orderby.equals("hits")) {
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByView(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page + "&orderby=" + orderby + "&cate=" + categoryId;
			} else if (orderby.equals("recom")) {
				Page<BoardDto> list = boardServiceInterface.listByCategoryOrderByRecom(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page + "&orderby=" + orderby + "&cate=" + categoryId;
			} else {
				Page<BoardDto> list = boardServiceInterface.listByCategory(category, pageable);
				int nowPage = list.getPageable().getPageNumber() + 1;
				int endPage = Math.min(nowPage + 4, list.getTotalPages());
				if (page > list.getTotalPages()) {
					page = endPage;
				}
				return "redirect:boardlist?page=" + page + "&cate=" + categoryId;
			}
		}
	}

	@GetMapping("search.do")
	public String search(Model model, String keyword, String searchForWhat,
			@PageableDefault(page = 0, size = 3, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
		System.out.println(searchForWhat);
		try {
			keyword = URLEncoder.encode(keyword, "utf-8");
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee);
		}
		return "redirect:boardlist?search=" + searchForWhat + "&keyword=" + keyword;
	}

	@GetMapping("/contentimages/{fileId}")
	@ResponseBody
	public Resource downloadImage(@PathVariable("fileId") Long id, Model model) throws IOException {
		return fileServiceInterface.downloadImage(id);
	}
}
