package com.tistory.postforty.book.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.postforty.book.springboot.domain.posts.Posts;
import com.tistory.postforty.book.springboot.domain.posts.PostsRepository;
import com.tistory.postforty.book.springboot.web.dto.PostsResponseDto;
import com.tistory.postforty.book.springboot.web.dto.PostsSaveRequestDto;
import com.tistory.postforty.book.springboot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // �Һ� ������̼�. �����ڷ� Bean ��ü �޵��� ��. Autowired�� ������ ȿ��. final ����� ��� �ʵ带 ���ڰ����� �ϴ� �����ڸ� ����. �ش� Ŭ������ ������ ���谡 ����� ������ ������ �ڵ带 ����ؼ� �����ϴ� ���ŷο� �ذ�
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id="+ id));
		posts.update(requestDto.getTitle(), requestDto.getContent());
		
		return id;
	}
	
	public PostsResponseDto findById (Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id=" + id));
		
		return new PostsResponseDto(entity);
	}

}
