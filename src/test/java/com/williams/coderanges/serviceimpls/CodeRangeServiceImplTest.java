package com.williams.coderanges.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeRangeServiceImplTest {

	@Autowired
	private CodeRangeServiceImpls codeRangeServiceImpl;

	@Test
	public void testResponse() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] { 94133, 94133 });
		list.add(new Integer[] { 94200, 94299 });
		list.add(new Integer[] { 94226, 94699 });
		List<Integer[]> request = codeRangeServiceImpl.getMinimumNumbersRange(list);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertEquals(response.get(0)[0], request.get(0)[0]);
	}
	

	@Test
	public void testResponse1() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		List<Integer[]> request = codeRangeServiceImpl.getMinimumNumbersRange(list);
		List<Integer[]> response = new ArrayList<>();
		Assertions.assertEquals(response, request);
	}


	@Test
	public void testNegativeResponse() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] { 94133, 94133 });
		list.add(new Integer[] { 94200, 94299 });
		list.add(new Integer[] { 94226, 94699 });
		List<Integer[]> entity = codeRangeServiceImpl.getMinimumNumbersRange(list);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertNotEquals(response, entity);
	}

}
