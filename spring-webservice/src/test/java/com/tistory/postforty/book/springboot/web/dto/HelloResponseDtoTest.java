package com.tistory.postforty.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; // assertj�� ������ CoreMatchers�� �޸� �߰��� ���̺귯�� ���ʿ�, �ڵ��ϼ��� ���� Ȯ��

public class HelloResponseDtoTest {
	
	@Test
	public void �Һ�_���_�׽�Ʈ() {
		// given
		String name = "test";
		int amount = 1000;
		
		// when
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		// then
		assertThat(dto.getName()).isEqualTo(name); // assertj �׽�Ʈ ���̺귯���� assertThat �޼���. ���� ����� �޼��� ���ڷ� ����. �޼��� ü�̴� ���� isEqualTo(���� �� �޼���) �̾� ����Ͽ���
		assertThat(dto.getAmount()).isEqualTo(amount);
	}

}
