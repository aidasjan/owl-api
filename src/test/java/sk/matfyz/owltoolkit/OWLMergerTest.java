package sk.matfyz.owltoolkit;
import java.io.FileNotFoundException;

import sk.matfyz.owltoolkit.OWLMerger;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OWLMergerTest {

	@Test
	public void test() throws Exception {
		OWLMerger.main("uploads/merged.owl", "src/test/resources/academy.owx", "src/test/resources/climbing.rdf");
	}

}
