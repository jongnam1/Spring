package com.springStudy1.control;

import org.springframework.stereotype.Controller; // <-subvlet 클래스와 같은 역할 함
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller // 진짜 이름에 맞게 붙여야 함 class가 service면 service로 해야됨
public class MainControl {//<- @controller 하면 서블릿으로 등록시킴 
     
	@GetMapping("/test") // localhost/test ( "요청처리주소") 
	public String testPage() { // <- 이게 실행된다
		System.out.println("와 진짜 실행된다.... 한글 좋아...");
		return "hello.html";  // <- 브라우저에서 페이지 띄우는 방법
	}
	
    @GetMapping("/signIn")
    public String signInpage() { //메소드 이름은 자유로 가능
    	System.out.println("아이디 비번 출력 :");
    	return "signIn.html";
	
}
 
    @GetMapping("/")
    public String homePage() {  //페이지를 제공하는 1번째 방법
    	return "index.html";
    }
    
    @GetMapping("/list")
    public ModelAndView listpage(@RequestParam String type) {
    	System.out.println(type);
    	ModelAndView mav = new ModelAndView("list.html"); // 페이지를 제공하는 2번째 방법
//    	mav.setViewName("");
    	
    	
    	
    	return mav;
    }
    


    }
    
// 주소 : http://localhost/signIn
// 뷰 페이지 : signIn.html
//       내용 : 아이디 , 비밀번호 입력 가능하게



/*
 
   컨트롤 클래스의 역할 지정 - @Controller 를 클래스 위에 넣기
 
   클라이언트의 요청 처리
     GET 방식으로 주소 요청 들어온다면 @GetMapping
     POST방식으로 주소 요청 들어온다면 @PostMapping
     
     @GetMapping("주소")
       @GetMapping("/list") -> localhost/list 주소요청 시 동작
       
       주소 요청시 실행 할 코드는 메서드로 표현 한다.
       @PostMapping("/save")
       Public String boardSave(){
       
       }
       -> localhost/save 주소가 post방식으로 요청되는 경우 boardSave 메서드 실행
*/