package com.shop.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.common.BoardVO;
import com.shop.common.MemberVO;
import com.shop.model.BoardDAO;
import com.shop.model.MemberDAO;

class DAOTest {
	private BoardDAO dao1;
	private MemberDAO dao2;
	private BoardVO vo1;
	private MemberVO vo2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		vo1 = new BoardVO();
		dao1 = new BoardDAO();
		vo1.setTitle("유닛테스트 title1");
		vo1.setContent("유닛테스트 content");
		vo1.setName("관리자");
		
		vo2 = new MemberVO();
		dao2 = new MemberDAO();
		
		System.out.println("DAO테스트 시작");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("DAO테스트 종료");
	}

	@Test
	void test() {
		dao1.addBoard(vo1);		//설정한 vo1의 값을 dao1에 더해
		fail("DAO 테스트 실패");
	}

}
