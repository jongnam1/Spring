package com.springStudy1.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springStudy1.DTO.User;

@Repository
public class UserDao {
    
	private final JdbcTemplate jdbc;
	
	@Autowired
	public UserDao(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	public boolean findByuserId(String userId) { //아이디중복 확인
	    String sql="select user_id from user where user_id=?";
		
	    try {
		String id = jdbc.queryForObject(sql, String.class, userId );
		
	    }catch(EmptyResultDataAccessException e) { // catch 부분이 실행된다는것은 조회결과가 없다는 뜻
	    	return false; // 아이디가 중복이 아니다.
	    }
	    
	    return true;// 아이가 중복이다.
		
		
	}
    
	public void insert(User user) { // 회원정보를 테이블에 저장
		String sql="insert into user(user_id, user_pw, user_email, user_job, user_addr, user_like)"
				+"values(?,?,?,?,?,?)";
	    jdbc.update(sql,user.getUserId(),user.getUserPw(),user.getUserEmail(),user.getUserJob(),
	    user.getUserAddr(), user.getUserLike() );
		
	}

	public boolean findByUserIdAndUserPw(String id, String pw) {
						   
			String sql = "select user_id from user where user_id=? and user_pw=?";
			
			try {
				String userId= jdbc.queryForObject(sql, String.class, id, pw);
			}catch(EmptyResultDataAccessException e) {
				return false; //아이디 또는 비밀번호가 틀려서 결과가 없다.
			}
			
			return true; // 로그인 성공 처리하기
	}
	
	
	}


