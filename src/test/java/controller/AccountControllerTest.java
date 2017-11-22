package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.Account;

public class AccountControllerTest {
	@InjectMocks
	private AccountController sut;

	@Mock
	Account account;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddPositivNumber() {
		// input
		BigDecimal value = new BigDecimal(1000);
		Mockito.when(account.getAmount()).thenReturn(new BigDecimal(1000));
		// call
		BigDecimal result = sut.add(value);
		// assert
		assertEquals(value.setScale(2), result);
	}

	@Test
	public void shouldNotAddNegativNumber() {
		// input
		BigDecimal value = new BigDecimal(-1000);
		// call
		BigDecimal result = sut.add(value);
		// Assert
		assertNull(result);
	}

	@Test
	public void shouldSubtractPositivNumber() {
		// input
		BigDecimal value = new BigDecimal(1000);
		Mockito.when(account.getAmount()).thenReturn(new BigDecimal(1000));
		BigDecimal expected = value.negate().setScale(2);
		// call
		BigDecimal result = sut.subtract(value);
		// assert
		assertEquals(expected, result);
	}

	@Test
	public void shouldNotSubtractNegativNumber() {
		// input
		BigDecimal value = new BigDecimal(-1000);
		// call
		BigDecimal result = sut.subtract(value);
		// Assert
		assertNull(result);
	}

	@Test
	public void shouldSeeHistory() {
		// input
		BigDecimal value = new BigDecimal(1000);
		BigDecimal value2 = new BigDecimal(500);
		Mockito.when(account.getAmount()).thenReturn(new BigDecimal(1000));
		sut.add(value);
		Mockito.when(account.getAmount()).thenReturn(new BigDecimal(500));
		sut.subtract(value2);
		// call
		LinkedList<String> result = sut.getHistory();
		// Assert
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == 2);
	}

}
