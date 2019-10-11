package eu.ensup.cabinet.dao;

import eu.ensup.cabinet.domaine.Medecin;

public interface IMedecinDao {
	public boolean create(Medecin pMedecin);
	public Medecin getById(int id);
}
