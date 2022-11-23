package ui;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bank.*;

public class HistoryTable extends AccountTable {

	HistoryTable() {
		super();
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
	}

	@Override
	public void setModel() {
		columnNames = new String[] { "거래구분", "거래일자", "금액" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		loadData();
		for (Savings.History h : account.historyList)
			tableModel.addRow(h.getTexts());
	}
	
	@Override
	public void update() {
		loadData();
		tableModel.setRowCount(0);
		for (Savings.History h : account.historyList)
			tableModel.addRow(h.getTexts());
	}
	
	void loadData() {
		account = Bank.accountMgr.list.get(selectedIndex);
	}
}