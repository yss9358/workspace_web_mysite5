package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		return sqlSession.selectOne("user.userSelectByIdPw",userVo);
	}
	
	// 회원가입
	public int personInsert(UserVo userVo) {
		int count= sqlSession.insert("user.insert",userVo);
		return count;
	}
	
	// 한명정보가져오기
	public UserVo selectOne(int no) {
		return sqlSession.selectOne("user.selectOne", no);
	}
	
	// 회원정보수정
	public int modify(UserVo userVo) {
		int count = sqlSession.update("user.update",userVo);
		return count;
	}
	
}
