package com.tistory.postforty.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{ // JpaRepository<Entity Ŭ����, PK Ÿ��> ����ϸ� �⺻ CRUD �޼��� �ڵ� ����. @Repository �߰� �ʿ� ����. Entity Ŭ������ �⺻ Entity Repository�� �Բ� ��ġ

}
