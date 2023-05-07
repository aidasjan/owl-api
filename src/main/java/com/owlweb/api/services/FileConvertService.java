package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLConverter;

@Service
public class FileConvertService {
	public String convertFile(String sourceFileName, String destinationFormat) {
		// Convert file to another format
		String destinationFileName = sourceFileName;
		try {

			String bareFileName = FilenameUtils.removeExtension(sourceFileName);


			switch (destinationFormat) {
				case "rdfxml":
					destinationFileName = bareFileName+".rdf";
					OWLConverter.main("-rdfxml", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
				case "owlxml":
					destinationFileName = bareFileName+".owx";
					OWLConverter.main("-owlxml", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
				case "turtle":
					destinationFileName = bareFileName+".ttl";
					OWLConverter.main("-turtle", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
				case "manchester":
					destinationFileName = bareFileName+".omn";
					OWLConverter.main("-manchester", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
				case "fss":
					destinationFileName = bareFileName+".ofn";
					OWLConverter.main("-fss", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
				case "latex":
					destinationFileName = bareFileName+".tex";
					OWLConverter.main("-latex", "uploads/"+sourceFileName, "uploads/"+destinationFileName);
					break;
			}
		} catch (Exception e) {
			System.err.println("Exception occured during conversion.");
		}

		// Return converted file name
		return destinationFileName;
	}
}
