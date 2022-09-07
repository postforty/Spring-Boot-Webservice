package com.tistory.postforty.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; // assertj의 장점은 CoreMatchers와 달리 추가적 라이브러리 불필요, 자동완성이 보다 확실

public class HelloResponseDtoTest {
	
	@Test
	public void 롬복_기능_테스트() {
		// given
		String name = "test";
		int amount = 1000;
		
		// when
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		// then
		assertThat(dto.getName()).isEqualTo(name); // assertj 테스트 라이브러리의 assertThat 메서드. 검증 대상을 메서드 인자로 받음. 메서드 체이닝 지원 isEqualTo(동등 비교 메서드) 이어 사용하였음
		assertThat(dto.getAmount()).isEqualTo(amount);
	}

}
