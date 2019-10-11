package testsV3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import eu.ensup.cabinet.dao.IMedecinDao;
import eu.ensup.cabinet.domaine.Medecin;
import eu.ensup.cabinet.service.MedecinService;

@RunWith(MockitoJUnitRunner.class)
public class TestMedecinService3 {

	@Mock // attention importer import org.mockito.Mock;
	IMedecinDao dao;

	@Test
	public void testLectureInfoMedecin3() {
		/*
		 * Scénario de test: La demande de lecture d'information d'un medecin à
		 * partir de son identifiant nous ramène la totalité de ses
		 * caractéristiques
		 */

		// 1: Mocker l'interface du dao
		// @Mock IMedecinDao dao; dans la classe de test

		// 2: Créer le service
		MedecinService meds = new MedecinService(dao);
		// 3: imposer un comportement au mock
		Mockito.when(dao.getById(1)).thenReturn(new Medecin(1, "herve", "lambert", "Stomatologue"));
		// 4: appeler une méthode du service
		Medecin medReturned = meds.lireInfoMedecin(1);
		// 5: Comparer le resultat réel avec le resultat attendu
		assertEquals(medReturned.getNom(), "herve");
		Mockito.verify(dao, Mockito.times(1)).getById(1);
	}

}
