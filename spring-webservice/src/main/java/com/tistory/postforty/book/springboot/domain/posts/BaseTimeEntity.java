package com.tistory.postforty.book.springboot.domain.posts;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
public class BaseTimeEntity {
	
	@CreatedDate // Entity가 생성될 때 시간을 자동 저장
	private LocalDateTime createdDate;
	
	@LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간을 자동 저장
	private LocalDateTime modifiedDate;

}
