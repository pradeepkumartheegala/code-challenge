package com.williams.coderanges.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CodeRangeService {

	List<Integer[]> getMinimumNumbersRange(List<Integer[]> codeList);

}
