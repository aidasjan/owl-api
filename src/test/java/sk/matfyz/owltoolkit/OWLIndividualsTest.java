package sk.matfyz.owltoolkit;
import java.io.IOException;

import sk.matfyz.owltoolkit.OWLIndividuals;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;


public class OWLIndividualsTest {

	@Test
	public void test() throws OWLOntologyCreationException, IOException {
		OWLIndividuals.main("src/test/resources/academy.owx");
		
	}

}
