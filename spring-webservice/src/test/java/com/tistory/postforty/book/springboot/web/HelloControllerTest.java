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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class) // �׽�Ʈ�� ������ �� JUnint�� ����� ������ �ܿ� �ٸ� �����ڸ� ����. ������ ��Ʈ �׽�Ʈ�� JUnit ���� ������ ����
@WebMvcTest(controllers = HelloController.class) // ���� ������ �׽�Ʈ ������̼� �� Web(Spring MVC) ��� ������ ������̼�
public class HelloControllerTest {
	
	@Autowired // �������� �����ϴ� Bean ���� ���� 
	private MockMvc mvc; // �� API �׽�Ʈ �����μ� HTTP GET, POST � ���� API �׽�Ʈ
	
	@Test
	public void hello��_���ϵȴ�() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello")) // MocMvc�� ���� /hello �ּҷ� HTTP GET ��û. ü�̴��� �����Ǿ� �Ʒ��� ���� ���� ���� ����� �̾ ���� ����
	        .andExpect(status().isOk()) // mvc.perform�� ��� ���� - HTTP Header�� Status ����
	        .andExpect(content().string(hello)); // mvc.perform�� ��� ���� - ���� ���� ���� ����
	}
	
	@Test
	public void helloDto��_���ϵȴ�() throws Exception {
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(get("/hello/dto")
				.param("name", name)
				.param("amount",  String.valueOf(amount))) // param�� API �׽�Ʈ�� �� ���� ��û �Ķ���͸� ����. ���� String�� ���
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.amount", is(amount))); // jsonPath�� JSON���䰪�� �ʵ庰�� �����ϴ� �޼���. $�� �������� �ʵ�� ���
	}
	
}
