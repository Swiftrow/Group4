/*
 * Department.java
 *
 * Created on 5. oktober 2006, 12:50
 *
 * 
 */

package ModelLayer;

/**
 *
 * @author kbh
 * @version _Date
 */
public class Department {
    private String dname;
    private int dnumber;
    private Employee manager;
    private String mgrstartdate;
    
    /** Creates a new instance of Department */
    public Department() {
    }
    public Department(int dnumber){
        this.dnumber = dnumber;
    }
    public Department(String dname, int dnumber)
    {
        this.dname = dname;
        this.dnumber = dnumber;
        manager = new Employee();
        mgrstartdate = "";
    }
    //set methods
    public void setDname(String dname)
    {
        this.dname = dname;
    }
    public void setDnumber(int dnumber)
    {
        this.dnumber = dnumber;
    }
    public void setManager(Employee manager)
    {
        this.manager = manager;
        
    }
    public void setStartdato(String startdate)
    {
        this.mgrstartdate = startdate;
    }
    //get methods
    public String getDname()
    {
        return dname;
    }
    public int getDnumber()
    {
        return dnumber;
        
    }
    public Employee getManager()
    {
        return manager;
        
    }
    public String getStartDato()
    {
        return mgrstartdate;
    }
}
