package sk.matfyz.owltoolkit;

import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;


public class OWLDeclarationsTest {

	@Test
	public void test() throws Exception {
		OWLDeclarations.main("src/test/resources/climbing.rdf", "uploads/declarations_climbing.owl" );
	}

}
