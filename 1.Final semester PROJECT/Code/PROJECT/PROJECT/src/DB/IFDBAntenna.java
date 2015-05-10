package DB;

import java.util.List;

import Model.Antenna;

public interface IFDBAntenna {
	public List<Antenna> getAllAntennas (boolean retrieveAssociation);
	public Antenna findAntenna (int id, boolean retrieveAssociation);
	public List<Antenna> searchAntenna( int id, boolean retrieveAssociation);
	public int updateAntenna(Antenna a);
	public int removeAntenna (Antenna a);
	public int insertAntenna (Antenna a);
}
