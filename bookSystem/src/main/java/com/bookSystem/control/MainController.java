package com.bookSystem.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookSystem.DTO.BookListDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.MemberDto;
import com.bookSystem.Service.BookService;
import com.bookSystem.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller

public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
    
    @GetMapping("/")
    public String home(Model model) {
    	MemberDto memberDto = new MemberDto();
    	model.addAttribute("memberDto", memberDto);
    	
    	
    	
    	return "index";
    }
	
    @PostMapping("/signIn")
    public String login(MemberDto memberDto, HttpSession session,Model model) {
    	System.out.println(memberDto.getEmail() );
    	
    	// 로그인처리를 진행하려면 service의 메서드를 호출한다.
    	// member와 관련 된것은 MemberService에서 처리한다.
    	// 컨트롤 쪽에서는 로그인처리과정이 어떻게 진행되고 하는지 전혀 몰라도 된다
    	// 그냥 service쪽 메서드를 호출하면된다.
    	boolean isSuccess = memberService.signIn( memberDto );
    	
    	if(isSuccess) { //로그인 성공시
            session.setAttribute("user", memberDto.getEmail());
        	return "redirect:/";
    	}
    	// 로그인 실패시 index.html 다시 돌아가기
    	model.addAttribute("fail", 1); //<- 1은 중요하지 않음
    	return "index";
    }
	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	session.removeAttribute("user");
    	return "redirect:/";
    }
    
    //도서 검색 부분
    @GetMapping("/bookSearch")
    public String search(Model model) {
    	
    	model.addAttribute("bookSearchDto", new BookSearchDto() );
    	
    	return "book/search";
    }
    @GetMapping("/bookSearch/result")  //검색어 입력하여 요청시
    public String searchResult(BookSearchDto bookSearchDto , Model model) {
    	
    	List<BookListDto> bookListDtos= bookService.bookSearch(bookSearchDto);
    	
    	model.addAttribute("bookListDtos", bookListDtos);
    	
    	return "book/search";
    }
    
    //도서검색 부분 끝
    
	
//	@GetMapping("/test")
//	public String main(Model model) {
//		model.addAttribute("name", "곽찬양");
//		model.addAttribute("age", 30);
//		model.addAttribute("tel", "010-2343-9874");
//		model.addAttribute("address", "남아프리카 공화국");	
//		
//		MemberDto memberDto = new MemberDto();
//		memberDto.setAge(29);
//		memberDto.setId("rim");
//		memberDto.setName("김은나");
//		memberDto.setTel("010-8888-0000");
//		
//		model.addAttribute("user", memberDto);
//		
//		List<String> animal = new ArrayList<>();
//		animal.add("개"); animal.add("호랑이");
//		animal.add("뱀"); animal.add("달");
//		animal.add("또끼"); animal.add("소");
//		
//		model.addAttribute("animal", animal);
//		
//		return "test";
//	}
	
	@GetMapping("/test2")
    public String test() {
		return "test2";
	}
	
}



/* 스프링의 동작은 기본적으로 mvc패턴이다.

 m: 모델(데이터 다루기위한 클래스)
 v: 뷰 (화면 페이지 - html)
 c: 컨트롤
 
 요청 -> 컨트롤 -> 로직(서비스) -> DAO(레포지토리) -> 서비스 -> 컨트롤 -> client
  
  
*/