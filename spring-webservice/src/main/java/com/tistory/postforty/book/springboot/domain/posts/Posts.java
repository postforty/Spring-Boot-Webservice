package com.tistory.postforty.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {
	
	@Id // PK 필드
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙, GenerationType.IDENTITY는 auto_increment
	private Long id;
	
	@Column(length = 500, nullable = false) // 선언하지 않아도 Column으로 인식하나 선언한 이유는 필요한 옵션을 주기 위함
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	@Builder // 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단 선언 시 생성자에 포함된 필드만 빌더에 포함
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
