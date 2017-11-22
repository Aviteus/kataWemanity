package model;

import java.util.LinkedList;

public class History {

	LinkedList <HistoryOperation> list= new LinkedList<HistoryOperation>();

	public void setOperation(HistoryOperation historyOperation) {
		list.add(historyOperation);
	}

	public LinkedList<HistoryOperation> getHistory() {
		return list;
	}

}
