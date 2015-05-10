package DB;

import java.util.List;

import Model.Telephone;

public interface IFDBTelephone {

	public List<Telephone> getAllTelephones(boolean retrieveAssociation);
	public Telephone findTelephone(int serialNo, boolean retrieveAssociation);
	public List<Telephone> searchTelephone(int serialNo, boolean retrieveAssociation);
	public int updateTelephone(Telephone t);
	public int removeTelephone(Telephone t);
	public int insertTelephone(Telephone t);
	
}
