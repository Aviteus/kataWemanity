package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.Test;

public class HistoryOperationTest {

	@Test
	public void shouldSetValuesAndGetThoseValue() {
		// input
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		BigDecimal value = new BigDecimal(10);
		String type = "credit";
		// call
		HistoryOperation sut = new HistoryOperation(timestamp, value, type, value);
		Timestamp time = sut.getTime();
		BigDecimal delta = sut.getDelta();
		String operation = sut.getOperation();
		BigDecimal bilan = sut.getBilan();
		// assert
		assertNotNull(time);
		assertEquals(value, delta);
		assertEquals(operation, operation);
		assertEquals(value, bilan);

	}

}
