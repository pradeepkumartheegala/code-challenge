package com.williams.coderanges.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williams.coderanges.services.CodeRangeService;

@RestController
@RequestMapping(value = "codeRanges")
public class CodeRangesController {

	@Autowired
	CodeRangeService codeRangeService;

	@PostMapping
	public ResponseEntity<List<Integer[]>> getMinimumNumbersRange(@RequestBody List<Integer[]> codeList) {
		try {
			return new ResponseEntity<List<Integer[]>>(codeRangeService.getMinimumNumbersRange(codeList),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
