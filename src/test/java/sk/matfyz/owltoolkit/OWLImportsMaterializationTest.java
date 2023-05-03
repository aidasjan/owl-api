package sk.matfyz.owltoolkit;
import sk.matfyz.owltoolkit.OWLImportsMaterialization;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;


public class OWLImportsMaterializationTest {

	@Test
	public void test() throws OWLOntologyCreationException, OWLOntologyStorageException {
		OWLImportsMaterialization.main("src/test/resources/academy.owx");
	}

}
