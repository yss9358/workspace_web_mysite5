package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 리스트가져오기
	public void list() {
		System.out.println("Dao>list");
		sqlSession.selectList("board.selectList");
		
	}
}
