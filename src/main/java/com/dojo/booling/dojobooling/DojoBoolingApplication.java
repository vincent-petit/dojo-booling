package com.dojo.booling.dojobooling;

import java.util.List;
import java.util.regex.Pattern;

public class DojoBoolingApplication {

	public static final Pattern REGEX = Pattern.compile("[0-9X/]");

	public static void main(String[] args) {
		List<String> inputs = checkInput(args);


		printResult(null);

	}

	static List<String> checkInput(String[] args) {
		List<String> inputs = List.of(args);
		inputs.forEach(i -> {
			if (!REGEX.matcher(i).matches()) {
				throw new IllegalArgumentException("bad char");
			}

		});
		return inputs;

	}

	static Integer printResult(List<Hit> hits) {
		return 0;
	}

}
