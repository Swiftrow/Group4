package modelLayer;

import java.util.*;

public class LoanContainer
{
    private ArrayList<Loan> loans;
    private static int idL=0;
    private static LoanContainer instance=null;

    public LoanContainer(){
        loans = new ArrayList<>();
    }

    public static LoanContainer getInstance(){
        if(instance == null){
            instance = new LoanContainer();
        }
        return instance;
    } 

    public void addLoan(Loan l){
        idL++;
        loans.add(l);
        l.setId(idL);
    }

    public Loan findLoan(int idL){
        for(Loan loan : loans){
            if(loan.getId()==idL){
                return loan;
            }
        }
        return null;
    }

    public void updateLoan(int idL, String status){
        for(Loan loan : loans){
            if(loan.getId()==idL){
                loan.setStatus(status);
            }
        }
    }

    public void deleteLoan(int idL){
        for(Iterator<Loan> i = loans.iterator(); i.hasNext();){
            Loan loan = i.next();
            if(loan.getId()==idL){
                i.remove();
            }
        }
    }

    public int getLoansNo(){
        return loans.size();
    }

     public int getTotalAmountLoans(){
        int price=0,x;
        for(Loan loan: loans ){
            x=loan.getTotalPrice();
            x=loan.discountPrice();
            price=price+x;
        }
        
        return price;
    }
}

