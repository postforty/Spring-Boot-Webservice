package com.tistory.postforty.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.postforty.book.springboot.web.dto.HelloResponseDto;

@RestController // ��Ʈ�ѷ��� JSON�� ��ȯ�ϴ� ��Ʈ�ѷ��� ����. @ResponsBody�� �� �޼ҵ帶�� �����ߴ� ���� �ѹ��� ����� �� �ְ� ��
public class HelloController {
	
	@GetMapping("/hello") // HTTP Method�� Get ��û�� ���� �� �ִ� API�� ����. @RequestMapping(method = RequestMethod.GET)�� ����.
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}

}
