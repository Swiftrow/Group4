package modelLayer;


public class Employee
{
    String name,address,phoneNo,email;
    int employeeId;
    int moneyMade,noOfSellsMade,noOfLoansMade;
    
    public Employee(String name, String address, String phoneNo, String email,int employeeId)
    {
       this.name=name;
       this.employeeId=employeeId;
       this.address=address;
       this.phoneNo=phoneNo;
       this.email=email;
       moneyMade=0;
       noOfSellsMade=0;
       noOfLoansMade=0;
    }
    

    public void setMoneyMade(int money) {
        moneyMade=moneyMade+money;
    }
    public int getMoneyMade() {
        return moneyMade;
    }
    
    public void setNoOfSells(int noOfSells) {
        noOfSellsMade=noOfSells+noOfSellsMade;
    }
    public int getNoOfSells() {
        return noOfSellsMade;
    }
    public void setNoOfLoans(int noOfLoan) {
        noOfLoansMade=noOfLoan+noOfLoansMade;
    }
    public int getNoOfLoans() {
        return noOfLoansMade;
    }
    public int getId(){
        return employeeId;
    }
    
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }
}
