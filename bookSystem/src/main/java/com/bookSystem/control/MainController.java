package com.bookSystem.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import DTO.MemberDto;

@Controller

public class MainController {
    
	
	@GetMapping("/test")
	public String main(Model model) {
		model.addAttribute("name", "곽찬양");
		model.addAttribute("age", 30);
		model.addAttribute("tel", "010-2343-9874");
		model.addAttribute("address", "남아프리카 공화국");	
		
		MemberDto memberDto = new MemberDto();
		memberDto.setAge(29);
		memberDto.setId("rim");
		memberDto.setName("김은나");
		memberDto.setTel("010-8888-0000");
		
		model.addAttribute("user", memberDto);
		
		List<String> animal = new ArrayList<>();
		animal.add("개"); animal.add("호랑이");
		animal.add("뱀"); animal.add("달");
		animal.add("또끼"); animal.add("소");
		
		
		return "test";
	}

}



/* 스프링의 동작은 기본적으로 mvc패턴이다.

 m: 모델(데이터 다루기위한 클래스)
 v: 뷰 (화면 페이지 - html)
 c: 컨트롤
 
 요청 -> 컨트롤 -> 로직(서비스) -> DAO(레포지토리) -> 서비스 -> 컨트롤 -> client
  
  
*/