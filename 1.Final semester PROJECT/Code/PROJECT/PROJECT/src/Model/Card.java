package Model;

public class Card {

	private int serialNo;
	private String entryDate;
	private String exitDate;
	private boolean active;
	
	
	public Card(int serialNo, String entryDate, String exitDate, boolean active) {
		super();
		this.serialNo = serialNo;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.active = active;
	}


	public Card() {
		// TODO Auto-generated constructor stub
	}


	public int getSerialNo() {
		return serialNo;
	}


	public String getEntryDate() {
		return entryDate;
	}


	public String getExitDate() {
		return exitDate;
	}


	public boolean isActive() {
		return active;
	}


	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	

}
