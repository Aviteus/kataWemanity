package controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;

import model.Account;
import model.History;
import model.HistoryOperation;

public class AccountController {
	private History histo = new History();
	private Account account = new Account();

	public BigDecimal add(BigDecimal value) {
		if (value!= null && value.compareTo(BigDecimal.ZERO)>0) {
			BigDecimal delta = value.setScale(2);
			account.setAmount(account.getAmount().add(delta));			
			Timestamp time = new Timestamp(System.currentTimeMillis());
			String operation="credit";
			BigDecimal bilan= account.getAmount();
			HistoryOperation opera=new HistoryOperation(time, delta, operation, bilan);
			histo.setOperation(opera);
			return account.getAmount();
		}else {
			return null;
		}
		
	}

	public BigDecimal subtract(BigDecimal value) {
		if (value!= null && value.compareTo(BigDecimal.ZERO)>0) {
			BigDecimal delta = value.setScale(2);
			account.setAmount(account.getAmount().subtract(delta));			
			Timestamp time = new Timestamp(System.currentTimeMillis());
			String operation="debit";
			BigDecimal bilan= account.getAmount();
			HistoryOperation opera=new HistoryOperation(time, delta, operation, bilan);
			histo.setOperation(opera);
			return account.getAmount();
		}else {
			return null;
		}
	}

	public LinkedList<String> getHistory() {
		LinkedList<String> result=new LinkedList<String>();
		StringBuilder builder;
		HistoryOperation actual;
		LinkedList<HistoryOperation> list=histo.getHistory();
		for (int i = 0; i < list.size(); i++) {
			actual= list.get(i);
			builder=new StringBuilder();
			builder.append(actual.getTime());
			builder.append(": ");
			builder.append(actual.getOperation());
			builder.append(": ");
			builder.append(actual.getDelta());
			builder.append(" ");
			builder.append("total: ");
			builder.append(actual.getBilan());
			result.add(builder.toString());
        }
		return result;
	}

}
