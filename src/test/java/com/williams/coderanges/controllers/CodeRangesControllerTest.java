package com.williams.coderanges.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.williams.coderanges.services.CodeRangeService;

@SpringBootTest
public class CodeRangesControllerTest {

	@InjectMocks
	CodeRangesController codeRangesController;

	@Mock
	CodeRangeService codeRangeService;

	@Test
	public void listPositiveResponseCode() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] { 94133, 94133 });
		list.add(new Integer[] { 94200, 94299 });
		list.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		ResponseEntity<List<Integer[]>> entity = codeRangesController.getMinimumNumbersRange(list);
		when(codeRangeService.getMinimumNumbersRange(list)).thenReturn(response);
		assertEquals(200, entity.getStatusCodeValue());
	}

	@Test
	public void listResponse() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] { 94133, 94133 });
		list.add(new Integer[] { 94200, 94299 });
		list.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		when(codeRangeService.getMinimumNumbersRange(list)).thenReturn(response);
		ResponseEntity<List<Integer[]>> entity = codeRangesController.getMinimumNumbersRange(list);
		assertEquals(response.get(0)[0], entity.getBody().get(0)[0]);
	}

	@Test
	public void listNegativeResponse() throws Exception {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] { 94133, 94133 });
		list.add(new Integer[] { 94200, 94299 });
		list.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		ResponseEntity<List<Integer[]>> entity = codeRangesController.getMinimumNumbersRange(list);
		when(codeRangeService.getMinimumNumbersRange(list)).thenReturn(response);
		assertNotEquals(response, entity.getBody());
	}
	
	
}
