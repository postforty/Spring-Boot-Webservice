package com.tistory.postforty.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tistory.postforty.book.springboot.config.auth.LoginUser;
import com.tistory.postforty.book.springboot.config.auth.dto.SessionUser;
import com.tistory.postforty.book.springboot.service.PostsService;
import com.tistory.postforty.book.springboot.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final PostsService postsService;
//	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) { // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. postsService.findAllDesc()에서 가져온 결과를 posts로 index.mustache에 전달
		model.addAttribute("posts", postsService.findAllDesc());
//		SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser 저장
		if (user != null) { // 세션에 저장된 값이 있을 때만 model에 userName 등록. 세션에 저장된 값이 없으면 로그인 버튼 노출
			model.addAttribute("userName", user.getName());
		}
		return "index";
	}
	
	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		
		return "posts-update";
	}
	
}
