package eu.ensup.cabinet.service;

import eu.ensup.cabinet.domaine.Medecin;
import eu.ensup.cabinet.domaine.Patient;

public interface IMedecinService {

	public boolean engagerMedecin(Medecin pMed);

	public Medecin lireInfoMedecin(int idMedecin);
	public void consulter (Patient p);
}
