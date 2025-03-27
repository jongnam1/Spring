package com.bookSystem.DTO;

import com.bookSystem.Entity.Book;

import lombok.Getter;
import lombok.Setter;
//2.폼태그에 작성할거 작성
@Getter
@Setter
public class BookWriteDto {

	private String bookTitle;
	private String bookAuthor;
	private String bookPublishing;
	private int bookYear;
	
	public static BookWriteDto of(Book book) {
		BookWriteDto bookWriteDto = new BookWriteDto();
		bookWriteDto.setBookAuthor(book.getBookAuthor());
		bookWriteDto.setBookPublishing(book.getBookPublishing());
		bookWriteDto.setBookTitle(book.getBookTitle());
		bookWriteDto.setBookYear(book.getBookYear());
		
		return bookWriteDto;
	}
}

//DTO에서 사용자가 입력한 데이터를 받아오고
//Entity에 넘겨서 데이터베이스에 저장

// 데이터베이스에서 가져와서 Entity에 저장하고
// DTO에 넘겨서 뷰페이지 출력
















