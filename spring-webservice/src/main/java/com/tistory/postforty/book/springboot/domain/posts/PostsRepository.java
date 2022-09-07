package com.tistory.postforty.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{ // JpaRepository<Entity 클래스, PK 타입> 상속하면 기본 CRUD 메서드 자동 생성. @Repository 추가 필요 없음. Entity 클래스와 기본 Entity Repository는 함께 위치

}
