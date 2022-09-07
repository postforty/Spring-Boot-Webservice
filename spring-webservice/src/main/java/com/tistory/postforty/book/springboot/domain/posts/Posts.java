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
@Entity // ���̺�� ��ũ�� Ŭ����
public class Posts {
	
	@Id // PK �ʵ�
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK�� ���� ��Ģ, GenerationType.IDENTITY�� auto_increment
	private Long id;
	
	@Column(length = 500, nullable = false) // �������� �ʾƵ� Column���� �ν��ϳ� ������ ������ �ʿ��� �ɼ��� �ֱ� ����
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	@Builder // �ش� Ŭ������ ���� ���� Ŭ���� ����. ������ ��� ���� �� �����ڿ� ���Ե� �ʵ常 ������ ����
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
