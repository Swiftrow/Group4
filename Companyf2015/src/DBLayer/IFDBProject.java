package DBLayer;
import ModelLayer.Project;
/**
 * Write a description of interface IFDBProject here.
 *
 * @author kbh
 * @version (2006.10.20)
 */

public interface IFDBProject {
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  pnumber the numer of the project
     * @return Project the object with all the information about the project
     */
    public Project findProject(int pnumber);
}
