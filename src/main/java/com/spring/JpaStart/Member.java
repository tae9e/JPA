package com.spring.JpaStart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

//@Data
@Table(name = "MEMBER2")
//@Entity가 있으면 @Table 없어도 되는데 테이블 이름을 정해주기 위해 사용
@Entity
@SequenceGenerator(name="M",sequenceName = "member2_seq")
public class Member {
	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "M") // sequence
	@Column(name="id")
	private Long id;

	@Column(length = 20, name = "NAME")
	private String name;

	@Column(length = 30, name = "AGE")
	private Integer age;

	public Member() {
		System.out.println("member");
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

}
