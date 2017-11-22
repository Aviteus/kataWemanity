package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HistoryOperation {

	private Timestamp time;
	private BigDecimal delta;
	private String operation;
	private BigDecimal bilan;
	
	public HistoryOperation(Timestamp time, BigDecimal delta, String operation, BigDecimal bilan) {
		this.time = time;
		this.delta = delta;
		this.operation = operation;
		this.bilan = bilan;
	}
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public BigDecimal getDelta() {
		return delta;
	}

	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String type) {
		this.operation = operation;
	}

	public BigDecimal getBilan() {
		return bilan;
	}

	public void setBilan(BigDecimal bilan) {
		this.bilan = bilan;
	}




}
