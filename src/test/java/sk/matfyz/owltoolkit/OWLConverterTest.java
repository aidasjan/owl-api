package sk.matfyz.owltoolkit;
import java.io.FileNotFoundException;

import sk.matfyz.owltoolkit.OWLConverter;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OWLConverterTest {

	@Test
	public void test() throws Exception {
		OWLConverter.main("-owlxml", "src/test/resources/climbing.rdf", "src/test/resources/climbing.owx");
	}

}
