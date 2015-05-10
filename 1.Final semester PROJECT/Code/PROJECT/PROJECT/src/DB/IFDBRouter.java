package DB;

import java.util.List;

import Model.Router;

public interface IFDBRouter {
	public List<Router> getAllRouters (boolean retrieveAssociation);
	public Router findRouter (int id, boolean retrieveAssociation);
	public List<Router> searchRouter( int id, boolean retrieveAssociation);
	public int updateRouter(Router r);
	public int removeRouter (Router r);
	public int insertRouter (Router r);

}

