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
	private String data1 = "타이틀 테스트";
	private String data2 = "관리자";
	
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
		System.out.println("테스트 시작");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("테스트 종료");
	}

	@Test
	void test1() {
		board.setTitle("타이틀 테스트");
		System.out.println("데이터 : "+board.getTitle());
		assertEquals(data1, board.getTitle());
		fail("VOTest1 실패");
	}
	
	@Test
	void test2() {
		member.setName("관리자");
		System.out.println("데이터 : "+member.getName());
		assertEquals(data2, member.getName());
		fail("VOTest2 실패");
	}

}
