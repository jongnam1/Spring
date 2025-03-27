package com.bookSystem.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.Entity.Book;

@Mapper
public interface BookRepository {
	
	// 책 등록 - 테이블에 저장
	public int save(Book book);
	
	// 책 검색
	public List<Book> findByAll(BookSearchDto bookSearchDto );
    
}
