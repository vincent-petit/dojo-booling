package com.dojo.booling.dojobooling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HitTest {

	@Test
	void getLocalPoint_shouldSumValue() {
		Hit hit = new Hit("2", "3");

		Assertions.assertThat(hit.getLocalPoint()).isEqualTo(5);
	}
	@Test
	void getLocalPoint_shouldReturn10_whenSpare() {
		Hit hit = new Hit("2", "/");

		Assertions.assertThat(hit.getLocalPoint()).isEqualTo(10);
	}

	@Test
	void getLocalPoint_shouldReturn10_whenStrike() {
		Hit hit = new Hit("X", null);

		Assertions.assertThat(hit.getLocalPoint()).isEqualTo(10);
	}


	@Test
	void construct_shouldFail_whenStrikeInSecondLaunch() {

		Throwable t = Assertions.catchThrowable(() -> new Hit("2", "X"));

		assertThat(t).isInstanceOf(IllegalArgumentException.class);
		assertThat(t).isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	void construct_shouldFail_whenStrike_hasSecondLaunch() {
		Throwable t = Assertions.catchThrowable(() -> new Hit("X", "1"));

		assertThat(t).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void construct_shouldFail_whenSumOfNumberIsUpperTo9() {
		Throwable t = Assertions.catchThrowable(() -> new Hit("8", "2"));

		assertThat(t).isInstanceOf(IllegalArgumentException.class);
	}
}