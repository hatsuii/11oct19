package eu.ensup.cabinet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.ensup.cabinet.domaine.Medecin;


public class MedecinDao implements IMedecinDao{

	private String url="jdbc:mysql://localhost/toubib";
	private String login="root";
	private String passwd="";
	private Connection cn;
	private Statement st;

	public MedecinDao(){
		//se co à la bdd
		System.out.println("Medecin Dao");
		System.out.println("connection..");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("erreur connection, classnotfound");
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erreur connection, sqlexception");
			//e.printStackTrace();
		}


	}
	//crud
	@Override
	public boolean create(Medecin pMedecin){
		System.out.println("création médecin");
		try {
			st = cn.createStatement();
			String sql = "INSERT INTO `medecin` VALUES ("+pMedecin.getId()+",'" + pMedecin.getNom() + "','"
					+ pMedecin.getPrenom() +"','"+pMedecin.getSpecialite()+"',"+pMedecin.getPatient().getId()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("erreur sqlexception");
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public Medecin getById(int id){
		System.out.println("get medecin by ID");
		int idMed;
		String nom;
		String prenom;
		String specialite;

		Medecin med = null;
		try {
			st = cn.createStatement();
			String sql = "Select * FROM medecin WHERE id="+id+";";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				idMed = rs.getInt("id");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				specialite = rs.getString("specialite");
				med = new Medecin(idMed, nom, prenom, specialite);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return med;
	}

}
