package com.example.Project.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Project.entity.UserEntity;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestCustomerDao {
	@Autowired
	private UserDao userDao;
	@Test
	void findByEmailAndPassword() {
		 Optional<UserEntity> user = userDao.findByUsernameAndPassword("shivam", "sh12345");
		 System.out.println(user.orElseThrow(null));
		 assertEquals(0, 0);
	}
	/*
	@Test
	void findByDateOfBirthAndMobileNo() {
		Optional<UserEntity> cust = userDao.findByDateOfBirthAndMobileNo(LocalDate.of(1997, 5, 5), "1234567890");
		System.out.println(cust.orElseThrow());
		assertEquals(0, 0);
	}
	@Test
	void findAll() {
		List<UserEntity> cust = custDao.findAll();
		cust.forEach(System.out::println);
		assertEquals(2, cust.size());
	}*/

}
