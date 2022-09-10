package com.tistory.postforty.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 메서드의 파라미터로 선언된 객체에서만 사용하는 어노테이션 생성
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // @interface는 어노테이션 클래스를 지정

}
