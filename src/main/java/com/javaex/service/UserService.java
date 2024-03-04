package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	// 로그인
	public UserVo exeLogin(UserVo userVo) {
		return userDao.userSelectByIdPw(userVo);
	}
	
	// 회원가입
	public int exeJoin(UserVo userVo) {
		int count = userDao.personInsert(userVo);
		return count;
	}
	
	// 한명정보가져오기
	public UserVo exeSelectOne(int no) {
		return userDao.selectOne(no);
	}
	
	// 회원정보수정
	public int exeModify(UserVo userVo) {
		int count = userDao.modify(userVo);
		return count;
	}
}
