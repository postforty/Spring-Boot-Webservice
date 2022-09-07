package com.tistory.postforty.book.springboot.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 �����ͺ��̽� �ڵ� ����
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	
	@After // Junit���� ���� �׽�Ʈ�� ���� ������ ����Ǵ� �޼��� ����
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void �Խñ�����_�ҷ�����() {
		// given
		String title = "�׽�Ʈ �Խñ�";
		String content = "�׽�Ʈ ����";
		
		postsRepository.save(Posts.builder() // id ���� �ִٸ� update, ���ٸ� insert ���� ����
				.title(title)
				.content(content)
				.author("dandycode.kr@gmail.com")
				.build());
		
		// when
		List<Posts> postsList = postsRepository.findAll(); // ���̺� posts�� �ִ� ��� ������ ��ȸ
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
}
