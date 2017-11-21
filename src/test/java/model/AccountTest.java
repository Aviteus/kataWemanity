package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.junit.Test;

public class AccountTest {

	private Account sut;

	private int scale = 2;

	@Test
	public void shouldBeZeroAtTheBeginning() {
		// Input
		BigDecimal expected = BigDecimal.ZERO;
		expected = expected.setScale(scale);
		// Call
		BigDecimal actual = sut.getAmount();
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void shouldGettheSettedValue() {
		// Input
		BigDecimal expected = new BigDecimal(1);
		expected.setScale(scale);
		BigDecimal input = new BigDecimal(1);
		input = input.setScale(scale);
		// Call
		sut.setAmount(input);
		BigDecimal actual = sut.getAmount();
		// Assert
		assertEquals(expected, actual);
	}

}
