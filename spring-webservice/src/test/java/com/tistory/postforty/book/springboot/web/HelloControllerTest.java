package com.tistory.postforty.book.springboot.web;

import static org.hamcrest.Matchers.is;
//import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tistory.postforty.book.springboot.config.auth.SecurityConfig;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnint에 내장된 실행자 외에 다른 실행자를 실행. 스프링 부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)}) // 여러 스프링 테스트 어노테이션 중 Web(Spring MVC) 기능 위주의 어노테이션
public class HelloControllerTest {
	
	@Autowired // 스프링이 관리하는 Bean 주입 받음 
	private MockMvc mvc; // 웹 API 테스트 용으로서 HTTP GET, POST 등에 대한 API 테스트
	
	@WithMockUser(roles="USER")
	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello")) // MocMvc를 통해 /hello 주소로 HTTP GET 요청. 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
	        .andExpect(status().isOk()) // mvc.perform의 결과 검증 - HTTP Header의 Status 검증
	        .andExpect(content().string(hello)); // mvc.perform의 결과 검증 - 응답 본문 내용 검증
	}
	
	@WithMockUser(roles="USER")
	@Test
	public void helloDto가_리턴된다() throws Exception {
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(get("/hello/dto")
				.param("name", name)
				.param("amount",  String.valueOf(amount))) // param은 API 테스트할 때 사용될 요청 파라미터를 설정. 값은 String만 허용
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.amount", is(amount))); // jsonPath는 JSON응답값을 필드별로 검증하는 메서드. $를 기준으로 필드명 명시
	}
	
}
