package com.stsc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stsc.controllers.MaximumIntegerController;
import com.stsc.controllers.request.MaxIntegerRequest;
import com.stsc.controllers.request.MaxIntegerResponse;

@SpringBootTest
class TechnicalTestApplicationTests {

	@Autowired
	MaximumIntegerController maximumIntegerController;
	
	@Test
	void test0() {
		MaxIntegerRequest request = new MaxIntegerRequest(7, null, null);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertNull(response.getK());
	}
	
	@Test
	void test1() {
		MaxIntegerRequest request = new MaxIntegerRequest(7, 5, 12345);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(12339, response.getK());
	}
	
	@Test
	void test2() {
		MaxIntegerRequest request = new MaxIntegerRequest(5, 0, 4);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(0, response.getK());
	}
	
	@Test
	void test3() {
		MaxIntegerRequest request = new MaxIntegerRequest(10, 5, 15);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(15, response.getK());
	}
	
	@Test
	void test4() {
		MaxIntegerRequest request = new MaxIntegerRequest(17, 8, 54321);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(54306, response.getK());
	}
	
	@Test
	void test5() {
		MaxIntegerRequest request = new MaxIntegerRequest(499999993, 9, 1000000000);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(999999995, response.getK());
	}
	
	@Test
	void test6() {
		MaxIntegerRequest request = new MaxIntegerRequest(10, 5, 187);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(185, response.getK());
	}
	
	@Test
	void test7() {
		MaxIntegerRequest request = new MaxIntegerRequest(2, 0, 999999999);
		MaxIntegerResponse response = maximumIntegerController.getMaximumInteger(request);
		
		assertEquals(999999998, response.getK());
	}

}
