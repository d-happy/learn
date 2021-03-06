package com.kh.sample01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample01.dao.BoardDao;
import com.kh.sample01.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Inject
	private LikeDao likeDao;
	
	@Inject
	private BoardDao boardDao;

	@Override
	@Transactional
	public void insertLike(String user_id, int b_no) throws Exception {
		likeDao.insertLike(user_id, b_no);
		boardDao.updateLikeCount(1, b_no); // like_count + ?
	}

	@Override
	public boolean isLike(String user_id, int b_no) throws Exception {
		boolean isLike=likeDao.isLike(user_id, b_no);
		return isLike;
	}

	@Override
	@Transactional
	public void deleteLike(String user_id, int b_no) throws Exception {
		likeDao.deleteLike(user_id, b_no);
		boardDao.updateLikeCount(-1, b_no);
	}

}
