package application;

import javafx.beans.property.SimpleStringProperty;

public class TableData {
	SimpleStringProperty price, name, percentChange, change, symbol;
	
	public TableData(String price, String name, String percentChange, String change, String symbol) {
		this.price = new SimpleStringProperty(price);
		this.name = new SimpleStringProperty(name);
		this.percentChange = new SimpleStringProperty(percentChange);
		this.change = new SimpleStringProperty(change);
		this.symbol = new SimpleStringProperty(symbol);
	}
	
	public String getSymbol() {
		return symbol.get();
	}
	
	public void setSymbol(String s) {
		symbol.set(s);
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String n) {
		 name.set(n);
	}
	 
	public String getLastPrice() {
		return price.get();
	}
	public void setLastPrice(String p) {
		price.set(p);
	}
	
	public String getChange() {
		return change.get();
	}
	public void setChange(String c) {
		change.set(c);
	}
	
	public String getPercentChange() {
		return percentChange.get();
	}
	public void setPercentChange(String pc) {
		percentChange.set(pc);
	}
}

