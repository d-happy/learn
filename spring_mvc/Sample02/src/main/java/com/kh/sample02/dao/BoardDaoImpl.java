package com.kh.sample02.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.domain.BoardVo;
import com.kh.sample02.domain.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAMESPACE = "com.kh.sample02.board.";
	
	@Inject
	private SqlSession sqlSession;
	

	@Override
	public void insertArticle(BoardVo boardVo) {
		sqlSession.insert(NAMESPACE + "insertArticle", boardVo); 
	}

	@Override
	public List<BoardVo> boardList(PagingDto pagingDto) {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "boardList", pagingDto);
		return list;
	}

	@Override
	public BoardVo selectArticle(int b_no) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "selectArticle", b_no);
		return boardVo;
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		sqlSession.update(NAMESPACE + "updateArticle", boardVo);

	}

	@Override
	public void deleteArticle(int b_no) {
		sqlSession.delete(NAMESPACE + "deleteArticle", b_no);
	}

	@Override
	public void updateViewCnt(int b_no) {
		sqlSession.update(NAMESPACE + "updateViewCnt", b_no);
	}
	
	@Override
	public int listCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "listCount", pagingDto);
		return count;
	}
	
	@Override
	public void updateLikeCount(int like_count, int b_no) {
		Map<String, Object> map = new HashMap<>();
		map.put("like_count", like_count);
		map.put("b_no", b_no);
		sqlSession.update(NAMESPACE + "updateLikeCount", map);
	}
	
	@Override
	public void insertAttach(String fileName, int b_no) {
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("b_no", b_no);
		sqlSession.update(NAMESPACE + "insertAttach", map);
	}
	
	@Override
	public int getBnoNextVal() {
		int b_no = sqlSession.selectOne(NAMESPACE + "getBnoNextVal");
		return b_no;
	}
	
	@Override
	public String[] getFileNames(int b_no) {
		List<String> filenames = sqlSession.selectList(NAMESPACE + "getFileNames", b_no);
		String[] arr = new String[filenames.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = filenames.get(i);
		}
		return arr;
	}
	
}
