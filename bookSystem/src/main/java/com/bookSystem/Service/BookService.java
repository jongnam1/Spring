package com.bookSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookSystem.DTO.BookListDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.BookWriteDto;
import com.bookSystem.Entity.Book;
import com.bookSystem.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	//데이터베이스에 저장
	public void bookSave(BookWriteDto bookWriteDto) {
		Book book = Book.of(bookWriteDto);
		bookRepository.save(book);
	}

		
	
	
	public List<BookListDto> bookSearch(BookSearchDto bookSearchDto){
	
		List<BookListDto> bookListDtos = new ArrayList<>();
		List<Book> books =bookRepository.findByAll(bookSearchDto);
		
		for(Book book : books) {
			BookListDto bookListDto = new BookListDto(
			 book.getBookId(),
			 book.getBookTitle(),
			 book.getBookAuthor(),
			 book.getBookPublishing()
					);
			bookListDtos.add(bookListDto);
		}
		return bookListDtos;
	}
};