package view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import controller.AccountController;

public class AccountViewTest {
	@InjectMocks
	private AccountView sut;

	@Mock
	AccountController accountController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAdd() {
		String input = "1";

		InputStream in = new ByteArrayInputStream(input.getBytes());


		System.setIn(in);

		Mockito.when(accountController.add(Mockito.any(BigDecimal.class))).thenReturn(new BigDecimal(1));
		sut.menu();
		

	}

	@Test
	public void shouldSubstract() {
		String input = "2";

		InputStream in = new ByteArrayInputStream(input.getBytes());

		Mockito.when(accountController.subtract(Mockito.any(BigDecimal.class))).thenReturn(new BigDecimal(1));
		System.setIn(in);
		
		sut.menu();
	}

	@Test
	public void shouldSee() {
		String input = "3";
		
		InputStream in = new ByteArrayInputStream(input.getBytes());
	
		LinkedList <String> message=new LinkedList<String>();
		message.add("hi");
		Mockito.when(accountController.getHistory()).thenReturn(message);
		System.setIn(in);

		sut.menu();
	}

	

	public void shouldbug() {
		String input = "a";

		InputStream in = new ByteArrayInputStream(input.getBytes());

		System.setIn(in);
		sut.menu();

	}
}
