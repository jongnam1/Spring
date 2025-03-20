package com.springStudy1.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolDAO {
    private final JdbcTemplate jdbc;
    
    @Autowired // 의존성주입이 필요한 곳에 사용
    public SchoolDAO( JdbcTemplate jdbc) {
    	this.jdbc = jdbc;
    }
}
