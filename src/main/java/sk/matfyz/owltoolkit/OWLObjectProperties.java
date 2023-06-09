package sk.matfyz.owltoolkit;
import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class OWLObjectProperties {

	public static void main(String... args) throws OWLOntologyCreationException {
		
		if (args.length != 1){
			System.err.println("Usage: OWLObjectProperties input_file");
			System.exit(0);
		}
		
		OWLOntology ontology = OWLManager.createOWLOntologyManager()
				.loadOntologyFromOntologyDocument(new File(args[0]));

		System.err.println("Ontology " + ontology.getOntologyID().getOntologyIRI());

        ontology.objectPropertiesInSignature().forEach(System.out::println);

	}

}
