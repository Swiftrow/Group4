package Model;

public class Router {

	private int serialNo;
	private String type;
	
	public Router() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Router(int serialNo, String type) {
		super();
		this.serialNo = serialNo;
		this.type = type;
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

}
