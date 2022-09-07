package com.tistory.postforty.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.postforty.book.springboot.web.dto.HelloResponseDto;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만듦. @ResponsBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 함
public class HelloController {
	
	@GetMapping("/hello") // HTTP Method인 Get 요청을 받을 수 있는 API를 만듦. @RequestMapping(method = RequestMethod.GET)와 동일.
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}

}
