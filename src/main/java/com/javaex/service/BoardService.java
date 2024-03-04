package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	// 리스트 가져오기
	public List<BoardVo> exeList() {
		return boardDao.selectList();
	}
	
	// 글쓰기
	public int exeWrite(BoardVo boardVo) {
		int count = boardDao.insert(boardVo);
		return count;
	}
}
