package Model;


import java.util.ArrayList;
import java.util.List;

public class Subscription {

	private int id, type;
	private List<Object> obj = new ArrayList<>();;
	
	public Subscription(int id, int type) {
		super();
		this.id = id;
		this.type = type;
		
		
	}

	public Subscription() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ArrayList<Object> getObj() {
		return obj;
	}

	public void setObj(ArrayList<Object> obj) {
		this.obj = obj;
	}

	

}
