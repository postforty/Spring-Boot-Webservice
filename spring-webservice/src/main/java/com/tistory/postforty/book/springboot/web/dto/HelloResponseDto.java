package com.tistory.postforty.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // ����� ��� final �ʵ尡 ���Ե� ������ ����(final ���� �ʵ�� ������ ���Ե��� ����)
public class HelloResponseDto {
	
	private final String name;
	private final int amount;

}
