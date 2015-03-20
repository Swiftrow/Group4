

package ModelLayer;

/**
 *
 * @author kbh
 * @version 2006.10.04
 */
public class Employee {
    
    //instance variables 
    private String fname;
    private String minit;
    private String lname;
    private String ssn;
    private String bdate;
    private String address;
    private String sex;
    private double salary;
    private Employee supervisor;
    private Department dep;
    public Employee() {
        
    }
    public Employee(String ssn){
        this.ssn = ssn;
    }
    public Employee (String fname, String minit, String lname, String ssn, String bdate, String address,
                     String sex, double salary, Employee supervisor, Department dep)
    {
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.ssn = ssn;
        this.bdate = bdate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.supervisor = supervisor;
        this.dep = dep;
    }
    //set methods
    public void setFname(String fname)
    {
        this.fname = fname;
    }
    public void setMinit (String minit){
        this.minit = minit;
    }
    public void setLname (String lname){
        this.lname = lname;
    }
    public void setSsn (String ssn){
        this.ssn = ssn;
    }
    public void setBdate(String bdate)
    {
        this.bdate = bdate;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public void setSupervisor(Employee emp)
    {
        this.supervisor = emp;
    }
    public void setDepartment(Department dep)
    {
        this.dep = dep;
    }
    //get method
    public String getFname()
    {
        return fname;
    }
    public String getMinit()
    {
        return minit;
    }
     public String getLname()
    {
        return lname;
    }
    public String getSsn()
    {
        return ssn;
    }
     public String getBdate()
    {
        return bdate;
    }
    public String getAddress()
    {
        return address;
    }
     public String getSex()
    {
        return sex;
    }
    public double getSalary()
    {
        return salary;
    }
    public Employee getSupervisor()
    {
        return supervisor;
    }
    public Department getDept()
    {
        return dep;
    }
    
}
    
   