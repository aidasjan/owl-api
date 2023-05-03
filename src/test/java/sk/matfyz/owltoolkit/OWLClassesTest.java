package sk.matfyz.owltoolkit;
import java.io.IOException;

import sk.matfyz.owltoolkit.OWLClasses;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;


public class OWLClassesTest {

	@Test
	public void test() throws OWLOntologyCreationException, IOException {
		OWLClasses.main("src/test/resources/climbing.rdf");
		
	}

}
