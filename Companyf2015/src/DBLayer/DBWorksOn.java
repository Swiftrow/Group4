

package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * DBWorksOn.java
 * @author kbh
 * @version 20. oktober 2006
 */
public class DBWorksOn implements IFDBWorksOn {
    private  Connection con;
    /** Creates a new instance of DBWorksOn */
    public DBWorksOn() {
        con = DbConnection.getInstance().getDBcon();
    }
    
    public ArrayList<WorksOn> findWorksOn(String ssn)
    {
        ArrayList<WorksOn> worksonObjects = new ArrayList<WorksOn>();
        worksonObjects = miscWhere("essn = '" + ssn + "'",true);
        return worksonObjects;
    }
    
    
    private ArrayList<WorksOn> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<WorksOn> list = new ArrayList<WorksOn>();	
		
		String query =  buildQuery(wClause);
                System.out.println("DBWorkson" + query);  
  		try{ // read from workson
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		 System.out.println("DBWorkson 2" );  

			while( results.next() ){
		     	 WorksOn worksObj = new WorksOn();
			 worksObj = buildWorksOn(results);	
                         list.add(worksObj);	
			}//end while
			stmt.close();
                        if(retrieveAssociation)// for each workson object find the project name
                        {
                            IFDBProject dbProject = new DBProject();
                            for(WorksOn wobj : list){
                               int pnumber = wobj.getProject().getPnumber();
                               Project pobj = dbProject.findProject(pnumber);
                               wobj.setProject(pobj);
                            }
                            
                        }
                        
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
    private WorksOn buildWorksOn(ResultSet results)
    {
        WorksOn wobj = new WorksOn();
        Employee empobj = new Employee();
        Project projobj = new Project();
        wobj.setEmp(empobj); //make reference to employee
        wobj.setProject(projobj); //make reference to project
         try{
               empobj.setSsn(results.getString("essn"));
               projobj.setPnumber(results.getInt("pno"));
               wobj.setHours(results.getDouble("hours"));
          }
         catch(Exception e)
         {
             System.out.println("building workson object");
         }
        
        return wobj;
        
    }
    //method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT essn, pno, hours FROM works_on";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
}
