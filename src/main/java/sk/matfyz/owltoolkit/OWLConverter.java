package sk.matfyz.owltoolkit;
import java.io.File;
import java.io.FileOutputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.*;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;

import org.semanticweb.owlapi.model.OWLOntologyManager;



public class OWLConverter {

	public static void main(String... args) throws Exception {

		if (args.length != 3){
			System.err.println("Usage: OWLConverter {-rdfxml | -owlxml | -turtle | -fss | -latex | -manchester } input_file output_file");
			System.exit(0);
		}
		
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File(args[1]));
		OWLDocumentFormat format = null;
		
		switch (args[0]) {
		case "-rdfxml":
			format = new RDFXMLDocumentFormat();
			break;
		case "-owlxml":
			format = new OWLXMLDocumentFormat();
			break;
		case "-turtle":
			format = new TurtleDocumentFormat();
			break;
		case "-manchester":
			format = new ManchesterSyntaxDocumentFormat();
			break;
		case "-fss":
			// workaround	for java.lang.IllegalArgumentException: Comparison method violates its general contract!
			//  at java.util.ComparableTimSort.mergeLo(ComparableTimSort.java:714)
			System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

			format = new FunctionalSyntaxDocumentFormat();
			break;	
		case "-latex":
			format = new LatexDocumentFormat();
			break;
		default:
			throw new Exception("Unknown format: " + args[0]);
		}
		
		FileOutputStream outputFOS = new FileOutputStream(args[2]);
		manager.saveOntology(ontology, format, outputFOS);
		outputFOS.close();

	}

}
