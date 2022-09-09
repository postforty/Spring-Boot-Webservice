package com.tistory.postforty.book.springboot.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tistory.postforty.book.springboot.domain.user.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정을 활성화 시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable함
				.and()
					.authorizeRequests() // URL별 권한 관리 설정 옵션의 시작점. 선언되어야 antMatchers 옵션 사용 가능
					.antMatchers("/", "/css/**", "/image/**", "/js/**", "/h2-console/**").permitAll()
					.antMatchers("/api/v1/**").hasRole(Role.USER.name())
					.anyRequest().authenticated() // 설정된 값들 외의 나머지 URL은 인증된 사용자들에게만 허용
				.and()
					.logout().logoutSuccessUrl("/") // 로그아웃 성공 시 /주소로 이동
				.and()
					.oauth2Login() // 로그인 기능에 대한 여러 설정 진입점
						.userInfoEndpoint() // 로그인 성공 시 사용자 정보를 가져올 때 설정 담당
							.userService(customOAuth2UserService); // 소설 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록. 추가로 진행하고자 하는 기능 명시할 수 있음
	}

}
