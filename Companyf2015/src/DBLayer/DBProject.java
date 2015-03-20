
package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.Project;

/**
 * DBProject.java
 * @author kbh
 * @version 20. oktober 2006, 17. oktober 2011
 */
public class DBProject implements IFDBProject {
    private  Connection con;
    private PreparedStatement pStmtSelect;
    /** Creates a new instance of DBWorksOn */
    public DBProject() {
        con = DbConnection.getInstance().getDBcon();
    }
    
    public Project findProject(int pnumber)
    {
        Project proObj = new Project();
       // proObj = singleWhere("pnumber = " + pnumber, false);
        proObj = findWithPreQuery(pnumber);
        return proObj;
    }
    //singlewhere is used when only one project object is to be build
    @SuppressWarnings("unused")
	private Project singleWhere(String wClause, boolean retrieveAssociation)
    {	
        ResultSet results;
        Project proObj = new Project();
        String query =  buildQuery(wClause);
        System.out.println("DbProject -singelWhere " + query); 
        try{ // read from project
        	Statement stmt = con.createStatement();
        	stmt.setQueryTimeout(5);
        	results = stmt.executeQuery(query);

	   if( results.next() ){
	       proObj = buildProject(results);
               //missing the test on retriveassociation
               
           }//end if
	   stmt.close();
	}//slut try	
	catch(Exception e){
	   System.out.println("Query exception - select project : "+e);
	   e.printStackTrace();
        }
	return proObj;

    
    }
    //miscWhere is used when more than one project is selected and build
    @SuppressWarnings("unused")
	private ArrayList<Project> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Project> list = new ArrayList<Project>();
		
		String query =  buildQuery(wClause);
                System.out.println("DbProject " + query); 
  		try{ // read from project
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 	
			while( results.next() ){
		     	 Project proObj = new Project();
			 proObj = buildProject(results);	
                         list.add(proObj);
                         //missing tes on retriveAssociation
			}//end while
			stmt.close();
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select project : "+e);
			e.printStackTrace();
	 	}
		return list;
	}
    private Project buildProject(ResultSet results)
    {
       Project proObj = new Project();
       
         try{
               proObj.setName(results.getString("pname"));
               proObj.setPnumber(results.getInt("pnumber"));
               proObj.setPlocation(results.getString("plocation"));
               
          }
         catch(Exception e)
         {
             System.out.println("building project object");
         }
        
        return proObj;
        
    }
    //method to build the query
	private String buildQuery(String wClause)
	{
            String query="SELECT pname, pnumber, plocation FROM project"; 
            
           

		if (wClause.length()>0)
			query = query + " where " + wClause;
			
		return query;
	}
        //
        public Project findWithPreQuery( int pnumber)
        {   System.out.println("Find with preCompiled");
            if(pStmtSelect == null){
               pStmtSelect =  getPreparedStmt();          
            }
            Project pObj = null;
            ResultSet results;
            try{
           
            pStmtSelect.setInt(1,pnumber);
            results = pStmtSelect.executeQuery();
            if(results.next()){
                 pObj = buildProject(results);	
            }
            }
            catch(Exception e){
                e.getMessage();
            }
            return pObj;
       }
        private PreparedStatement getPreparedStmt()
        {
           try{ 
            String query = "select pname, pnumber, plocation from project" +
                           " where pnumber = ?";
            System.out.println("Preparestatement " + query);
            pStmtSelect = con.prepareStatement(query);
            
           }
           catch(Exception e){
                e.getMessage();
            }
           return pStmtSelect;
        }
        
        // example using  prepared stmt
        public int insertProject(Project pObj)
        { 
            int rc = -1; 
            PreparedStatement pstmt = null;
             String insert = "insert into project (pname, pnumber,plocation, dnum)"+
                     "values (?,?,?,?)";
             System.out.println(insert);
             try{
                pstmt = con.prepareStatement(insert);
                pstmt.setString(1,pObj.getName());
                pstmt.setInt(2, pObj.getPnumber());
                pstmt.setString(3,pObj.getLocation());
                pstmt.setInt(4, pObj.getDepartment().getDnumber());
                rc = pstmt.executeUpdate();
                                 
                
             }
             catch(SQLException sqlE)
             {
                 System.out.println("SQL Error");
                 System.out.println(sqlE.getMessage());   
             }
             catch(Exception e){
                 e.getMessage();
                 
             }
             return rc;
             
        }
        public int deleteProject(int pnumber)
        {
           int rc = -1;
           PreparedStatement pstmt = null;
           String delete = "delete from project where pnumber = ?";
           System.out.println(delete);
             try{
                pstmt = con.prepareStatement(delete);
                pstmt.setInt(1,pnumber);
                rc = pstmt.executeUpdate();                       
             }
             catch(SQLException sqlE)
             {
                 System.out.println("SQL Error");
                 System.out.println(sqlE.getMessage());   
             }
             catch(Exception e){
                 e.getMessage();
                 
             }
            return rc;
        }
        }


        
