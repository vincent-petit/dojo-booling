package com.dojo.booling.dojobooling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class DojoBoolingApplicationTests {


	@Test
	void checkInputs_shouldAcceptNumbersAndSparsesAndStrikes() {
		// GIVEN
		String[] inputs = {"1", "2", "X", "3", "/"};

		// WHEN
		List<String> results = DojoBoolingApplication.checkInput(inputs);

		// THEN
		assertThat(results).containsExactly("1", "2", "X", "3", "/");
	}


	@Test
	void checkInputs_shouldFailsWhenBadInputs() {
		// GIVEN
		String[] inputs = {"A"};

		// WHEN
		Throwable t = Assertions.catchThrowable(() -> DojoBoolingApplication.checkInput(inputs));

		assertThat(t).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void checkInputs_shouldFailsWhenSparesDoesntHaveFirstShoot() {
		// GIVEN
		String[] inputs = {"1", "2", "/"};

		// WHEN
		Throwable t = Assertions.catchThrowable(() -> DojoBoolingApplication.checkInput(inputs));

		assertThat(t).isInstanceOf(IllegalArgumentException.class);
	}
}
