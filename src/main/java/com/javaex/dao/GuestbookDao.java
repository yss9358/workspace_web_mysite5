package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 리스트가져오기
	public List<GuestbookVo> list() {
		return sqlSession.selectList("guestbook.list");
	}
	
	// 등록
	public int insert(GuestbookVo guestbookVo) {
		int count = sqlSession.insert("guestbook.insert",guestbookVo);
		return count;
	}
	
	// 삭제
	public int delete(GuestbookVo guestbookVo) {
		int count = sqlSession.delete("guestbook.delete",guestbookVo);
		return count;
	}
	
}
