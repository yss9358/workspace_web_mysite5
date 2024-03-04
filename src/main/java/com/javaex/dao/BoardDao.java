package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 리스트 가져오기
	public List<BoardVo> selectList() {
		return sqlSession.selectList("board.selectList");
	}
	
	// 글쓰기
	public int insert(BoardVo boardVo) {
		int count = sqlSession.insert("board.insert", boardVo);
		return count;
	}
	
}
