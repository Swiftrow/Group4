package Model;

public class Task {
	
	private Employee emp;
	private Contract contract;
	private int id, difficulty;
	private String type;
	
	
	public Task(Employee emp, Contract contract, int id, int difficulty,
			String type) {
		super();
		this.emp = emp;
		this.contract = contract;
		this.id = id;
		this.difficulty = difficulty;
		this.type = type;
	}


	public Employee getEmp() {
		return emp;
	}


	public Contract getContract() {
		return contract;
	}


	public int getId() {
		return id;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public String getType() {
		return type;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public void setType(String type) {
		this.type = type;
	}



}
