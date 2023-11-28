package com.spring.JpaStart;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.persistence.EntityListeners;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@EntityListeners(Member.class)
public class MemberServiceTests {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void saveMemberTest() {
		Member member = new Member();
		member.setName("aaa");
		member.setAge(32);
		memberRepository.save(member);
		
		Member m = memberRepository.findById(member.getId()).get();
		//객체 x, y 일치하는지 확인
		Assert.assertEquals(m.getName(), "aaa");
		Assert.assertEquals(m.getAge(), Integer.valueOf(32));
	}
}
