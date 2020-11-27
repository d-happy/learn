package com.kh.sample01.dao;

import java.util.List;

import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.domain.PagingDto;

public interface BoardDao {
	
	//글쓰기
	public void insertArticle(BoardVo boardVo);
	
	//글 목록
	public List<BoardVo> boardList(PagingDto pagingDto);
	
	//글 조회
	public BoardVo selectArticle(int b_no);
	
	//글 수정
	public void updateArticle(BoardVo boardVo);
	
	//글 삭제
	public void deleteArticle(int b_no);
	
	//조회수 증가
	public void updateViewCnt(int b_no);
	
	//페이징 
	public int listCount(PagingDto pagingDto);
}
