package com.dojo.booling.dojobooling;

import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.regex.Pattern;

public class Hit {
	public static final Pattern REGEX = Pattern.compile("[0-9X/]");
	public static final String STRIKE = "X";
	public static final String SPARE = "/";
	public final String firstLaunch;
	@Nullable
	public final String secondLaunch;

	public Hit(String firstLaunch, @Nullable String secondLaunch) {
		this.firstLaunch = firstLaunch;
		this.secondLaunch = secondLaunch;
		checkLaunch();
		checkLaunch();
	}

	private void checkLaunch() {
		if (!REGEX.matcher(firstLaunch).matches()) {
			throw new IllegalArgumentException("bad char");
		}
		if (!REGEX.matcher(secondLaunch).matches()) {
			throw new IllegalArgumentException("bad char");
		}
		if (STRIKE.equals(secondLaunch)) {
			throw new IllegalArgumentException("bad char");
		}

		if (SPARE.equals(firstLaunch)) {
			throw new IllegalArgumentException("bad char");
		}

		if (STRIKE.equals(firstLaunch) && secondLaunch != null) {
			throw new IllegalArgumentException("bad char");
		}
	}


	public int getLocalPoint() {

		if (STRIKE.equals(firstLaunch)) {
			return 10;
		}
		if (SPARE.equals(secondLaunch)) {
			return 10;
		}
		return Integer.valueOf(firstLaunch) + Integer.valueOf(secondLaunch);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Hit hit = (Hit) o;
		return Objects.equals(firstLaunch, hit.firstLaunch) &&
				Objects.equals(secondLaunch, hit.secondLaunch);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstLaunch, secondLaunch);
	}

	@Override
	public String toString() {
		return "Hit{" +
				"firstLaunch='" + firstLaunch + '\'' +
				", seconLanch='" + secondLaunch + '\'' +
				'}';
	}
}
