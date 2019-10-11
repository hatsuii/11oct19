package eu.ensup.cabinet.domaine;

public class Medecin extends Personne{
	private Patient patient;
	private String specialite;

	public Medecin(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}
	public Medecin(int id, String nom, String prenom, String specialite) {
		super(id, nom, prenom);
		this.specialite = specialite;
	}

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Info du médecin numéro "+getId()+" : "+getNom()+" - "+getPrenom()+" - "+getSpecialite();
	}

}
