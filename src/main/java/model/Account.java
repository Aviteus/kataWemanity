package model;

import java.math.BigDecimal;

public class Account {

	private BigDecimal amount = BigDecimal.ZERO.setScale(2);

	public BigDecimal getAmount() {

		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;

	}

}
