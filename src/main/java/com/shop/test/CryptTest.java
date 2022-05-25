package com.shop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptTest {
	private String data = "1234";
	private String encoding;
	private String indata = "MTIzNA=="; 	//1234를 암호화한 값
	private byte[] decoding;		//디코딩된 데이터는 바이트배열

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void CrypTest1() {		//암호화
		encoding = Base64.getEncoder().encodeToString(data.getBytes());		//바이트배열 데이터를 스트링으로 변환
		System.out.println("암호화된 데이터 : "+encoding);
		fail("암호화 실패");
	}

	@Test
	void CrypTest2() {		//복화화
		decoding = Base64.getDecoder().decode(indata);	//인코팅한 indata를 다시 디코딩
		String StrDecode = new String(decoding);		//바이트배열을 다시 string으로
		System.out.println("복호화된 데이터 : "+StrDecode);
		fail("복호화 실패");
	}
}
