package controlLayer;
import modelLayer.*;
public class LoanCtr
{
    private LoanContainer loanContainer;
    private static int idL;

    public LoanCtr(){
        loanContainer = LoanContainer.getInstance();
    }

    public int createLoan(String date, String period, Customer c, Employee e){
        Loan loan = new Loan(date,period,c,e);
        loanContainer.addLoan(loan);
        idL = loan.getId();
        return loan.getId();
    }

    public void addItemToLoan(OrderLineLoan orderLineLoan){
        loanContainer.findLoan(idL).addOrderLineLoan(orderLineLoan);
    }
    
    public int getId(){
        return idL;
    }
    
    public Loan findLoan(int idL){
        return loanContainer.findLoan(idL);
    }

    public void updateLoanStatus(int idL, String status){
        loanContainer.updateLoan(idL,status);
    }

    public void deleteLoan(int idL){
        loanContainer.deleteLoan(idL);
    }
    public int getLoansNo(){
        return loanContainer.getLoansNo();
    }
    public int getTotalAmountLoans(){
        return loanContainer.getTotalAmountLoans();
    }
}