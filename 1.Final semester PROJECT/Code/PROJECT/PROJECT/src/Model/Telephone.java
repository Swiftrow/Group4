package Model;

public class Telephone {

		private int serialNo;
		private String type;
		
		public Telephone(){}
		
		public Telephone(int serialNo, String type) {
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
