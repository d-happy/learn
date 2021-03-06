package com.kh.sample02.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.domain.BoardVo;
import com.kh.sample02.domain.MemberVo;
import com.kh.sample02.domain.PagingDto;
import com.kh.sample02.service.BoardService;
import com.kh.sample02.service.LikeService;
import com.kh.sample02.util.MyUrlUtil;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@Inject
	private LikeService likeService;
	
	@RequestMapping(value="/listAll2", method=RequestMethod.GET)
	public String listAll(Model model, PagingDto pagingDto) throws Exception {
//		System.out.println("pagingDto :" + pagingDto);
		int count = boardService.listCount(pagingDto);
		pagingDto.setTotalCount(count);
		pagingDto.setPagingInfo();
//		System.out.println("pagingDto-totalCount :" + pagingDto);
		
		List<BoardVo> boardList = boardService.boardList(pagingDto);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingDto", pagingDto);
		return "board/listAll2";
	}
	
	@RequestMapping(value="/writeForm2", method=RequestMethod.GET)
	public String writeForm() throws Exception {
		return "board/writeForm2";
	}
	
	@RequestMapping(value="/writeRun2", method=RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		boardVo.setUser_id(memberVo.getUser_id());
		System.out.println("boardVo :" + boardVo);
		boardService.insertArticle(boardVo);
		rttr.addFlashAttribute("msg", "writeSuccess");
		return "redirect:/board/listAll2";
	}
	
	@RequestMapping(value="/content2", method=RequestMethod.GET)
	public String content(int b_no, PagingDto pagingDto, Model model, HttpSession session) throws Exception {
//		System.out.println("b_no :" + b_no);
//		System.out.println("pagingDto-content :" + pagingDto);
		BoardVo boardVo = boardService.selectArticle(b_no);
//		boardVo.setLike_count(0);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("pagingDto", pagingDto);
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		boolean isLike = likeService.isLike(memberVo.getUser_id(), b_no);
//		System.out.println(isLike);
		model.addAttribute("isLike", isLike);
		return "board/content2";
	}
	
	@RequestMapping(value="/updateRun2", method=RequestMethod.POST)
	public String updateRun(BoardVo boardVo, PagingDto pagingDto, RedirectAttributes rttr) throws Exception {
//		System.out.println("boardVo:" + boardVo);
//		System.out.println("pagingDto-update :" + pagingDto);
		boardService.updateArticle(boardVo);
		rttr.addFlashAttribute("msg", "updateSuccess");
		String url = MyUrlUtil.makeurl(pagingDto, boardVo.getB_no(), "updateRun2");
		return "redirect:/board/content2" + url;
	}
	
	@RequestMapping(value="/deleteRun2", method=RequestMethod.GET)
	public String deleteRun(int b_no, PagingDto pagingDto, RedirectAttributes rttr) throws Exception {
		boardService.deleteArticle(b_no);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		String url = MyUrlUtil.makeurl(pagingDto, b_no, "deleteRun2");
		return "redirect:/board/listAll2" + url;
	}
	
}
