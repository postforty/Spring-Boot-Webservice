package com.tistory.postforty.book.springboot.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email); // email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단

}
