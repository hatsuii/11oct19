package testsV5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import eu.ensup.cabinet.dao.IMedecinDao;
import eu.ensup.cabinet.dao.MedecinDao;
import eu.ensup.cabinet.domaine.Medecin;

@RunWith(MockitoJUnitRunner.class)

public class TestMedecinService5 {

	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Spy
	IMedecinDao iMed = new MedecinDao();

	@Test
	public void test() {

		spiedList.add("one");
		spiedList.add("two");
		iMed.getById(1);

		Medecin medoc = new Medecin(5, "tibo", "inshape");
		Mockito.verify(spiedList).add("one");
		Mockito.verify(spiedList).add("two");
		Mockito.verify(iMed).getById(1);

		//assertEquals(2, spiedList.size());
		//assertEquals(1, iMed.getById(1));

		// attention coup au visage
		Mockito.doReturn(100).when(spiedList).size();
		Mockito.doReturn(medoc).when(iMed).getById(1);
		// et là on voit que le comportement à été modifié
		// assertEquals(100, spiedList.size());
		assertEquals(medoc, iMed.getById(1));

	}

}
