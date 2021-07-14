package com.williams.coderanges.serviceimpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.williams.coderanges.services.CodeRangeService;

@Service
public class CodeRangeServiceImpls implements CodeRangeService {

	Integer minValue = Integer.MAX_VALUE;
	Integer maxValue = 0;

	@Override
	public List<Integer[]> getMinimumNumbersRange(List<Integer[]> codesList) {

		minValue = Integer.MAX_VALUE;
		maxValue = 0;
		List<Integer[]> codeRange = new ArrayList<>();

		if (codesList.size() == 0)
			return codeRange;

		for (int i = 0; i < codesList.size(); i++) {
			int zipminValue = codesList.get(i)[0];
			int zipmaxValue = codesList.get(i)[1];
			if (codesList.get(i).length == 2 && (Math.floor(zipminValue) == zipminValue)
					&& (Math.floor(zipmaxValue) == zipmaxValue)) {
				if (minValue > zipminValue) {
					minValue = zipminValue;
				}
				if (maxValue < zipmaxValue) {
					maxValue = zipmaxValue;
				}
			}
		}

		String[] data = new String[maxValue - minValue + 1];
		codesList.forEach((code) -> Arrays.fill(data, code[0] - minValue, code[1] - minValue + 1, "range"));
		Integer leftRange = minValue - 1;
		Integer rightRange = minValue;
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == "range") {
				rightRange = minValue + i;
			}
			if (data[i] == null) {
				leftRange = minValue + i;
			}

			if (data[i] == "range" && data[i + 1] == null) {
				Integer[] lst = { leftRange + 1, rightRange };
				codeRange.add(lst);
			}
		}
		Integer[] last = { leftRange + 1, maxValue };
		codeRange.add(last);
		if (minValue == Integer.MAX_VALUE && maxValue == 0) {
			return codeRange;
		}
		return codeRange;
	}

}
