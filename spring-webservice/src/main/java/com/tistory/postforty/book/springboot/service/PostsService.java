package com.tistory.postforty.book.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.postforty.book.springboot.domain.posts.Posts;
import com.tistory.postforty.book.springboot.domain.posts.PostsRepository;
import com.tistory.postforty.book.springboot.web.dto.PostsListResponseDto;
import com.tistory.postforty.book.springboot.web.dto.PostsResponseDto;
import com.tistory.postforty.book.springboot.web.dto.PostsSaveRequestDto;
import com.tistory.postforty.book.springboot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 롬복 어노테이션. 생성자로 Bean 객체 받도록 함. Autowired와 동일한 효과. final 선언된 모든 필드를 인자값으로 하는 생성자를 생성. 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움 해결
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
		posts.update(requestDto.getTitle(), requestDto.getContent());
		
		return id;
	}
	
	public PostsResponseDto findById (Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		
		return new PostsResponseDto(entity);
	}
	
	@Transactional(readOnly = true) // 등록, 수정, 삭제 기능이 전혀 없는 서비스 메서드. 조회 기능만 남겨두어 조회 속도가 개선
	public List<PostsListResponseDto> findAllDesc() {
		return postsRepository.findAllDesc().stream()
				.map(PostsListResponseDto::new)
//				.map(posts -> new PostsListResponseDto(posts))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void delete(Long id) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
				
		postsRepository.delete(posts);
	}

}
