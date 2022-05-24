package com.shop.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.common.BoardVO;
import com.shop.common.MemberVO;

class VOTest {
	
	private BoardVO board;
	private MemberVO member;
	private String data1 = "제목";
	private String data2 = "admin"; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("인스턴스 시작");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("인스턴스 종료");
	}

	@BeforeEach
	void setUp() throws Exception {
		board = new BoardVO();
		member = new MemberVO();
		System.out.println("VO 테스트 시작");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("VO 테스트 종료");
	}

	@Test
	void VOtest1() {
		board.setTitle("제목");
		System.out.println("데이터: "+board.getTitle());
		assertEquals(data1, board.getTitle());
		fail("VOTest1 False");
	}

	@Test
	void VOtest2() {
		member.setU_id("admin");
		System.out.println("데이터: "+member.getU_id());
		assertEquals("data2", member.getU_id());
		fail("VOTest2 False");
	}
}
