package model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AccountTest {

	private Account sut = new Account();

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
		expected = expected.setScale(scale);
		BigDecimal input = new BigDecimal(1);
		input = input.setScale(scale);
		// Call
		sut.setAmount(input);
		BigDecimal actual = sut.getAmount();
		// Assert
		assertEquals(expected, actual);
	}

}
