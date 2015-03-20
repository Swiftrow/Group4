package DBLayer;
import ModelLayer.WorksOn;
import java.util.ArrayList;

/**
 * Write a description of interface IFDBWorksOn here.
 *
 * @author kbh
 * @version (2006.10.19)
 */

public interface IFDBWorksOn {
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  ssn	ssn for the employee
     * @return 		an arraylist holding objects of worksOn
     */
    public ArrayList<WorksOn> findWorksOn(String ssn);
}
