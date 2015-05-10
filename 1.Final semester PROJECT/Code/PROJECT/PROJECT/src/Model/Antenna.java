package Model;

public class Antenna {

	private int serialNo;
	private String type;
	private Cards card;
	
	public Antenna(int serialNo, String type, Card card) {
		super();
		this.serialNo = serialNo;
		this.type = type;
		this.card=card;
	}

	public Antenna() {
		// TODO Auto-generated constructor stub
	}


	
	public int getSerialNo() {
		return serialNo;
	}

	public String getType() {
		return type;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Cards getCards() {
		return cards;
	}

	public void setCards(Cards cards) {
		this.cards = cards;
	}

	
	
}
