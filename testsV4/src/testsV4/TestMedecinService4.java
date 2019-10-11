package testsV4;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import eu.ensup.cabinet.dao.IMedecinDao;
import eu.ensup.cabinet.domaine.Medecin;
import eu.ensup.cabinet.service.MedecinService;

@RunWith(MockitoJUnitRunner.class)
public class TestMedecinService4 {
	@Mock // attention importer import org.mockito.Mock;
	IMedecinDao dao;

	@InjectMocks // besoin d'un constructeur par défaut dans le service
	MedecinService meds;

	@Test
	public void testLectureInfoMedecin4() {

		// 1: Mocker l'interface du dao
		// @Mock IMedecinDao dao; dans la classe de test

		// 2: Créer le service
		// @InjectMocks MedecinService meds; remplace l'instanciation du service

		// 3: imposer un comportement au mock -> STUBBING
		Mockito.when(dao.getById(1)).thenReturn(new Medecin(1, "herve", "lambert", "Stomatologue"));
		// 4: appeler une méthode du service
		Medecin med = meds.lireInfoMedecin(1);
		// 5: Comparer le resultat réel avec le resultat attendu
		assertEquals("herve", med.getNom());
	}

}
