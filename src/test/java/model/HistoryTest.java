package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HistoryTest {
	@InjectMocks
	private History sut;
	@Mock
	HistoryOperation historyOperation;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSetAnElementAndReturnIt() {
		//input
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		BigDecimal value = new BigDecimal(10);
		String type = "credit";
		HistoryOperation historyOperation = new HistoryOperation(timestamp, value, type, value);
		//call
		sut.setOperation(historyOperation);
		LinkedList<HistoryOperation> list=sut.getHHistory();
		//assert
		assertNotNull(list);
		assertEquals(1, list.size());
	}

}
