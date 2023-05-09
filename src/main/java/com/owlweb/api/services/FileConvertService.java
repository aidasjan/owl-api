package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLConverter;

@Service
public class FileConvertService {
	public String convertFile(String sourceFileName, String destinationFormat) {
		String destinationFileName = java.util.UUID.randomUUID().toString();
		String destinationFilePath = "uploads/" + destinationFileName;

		try {
			switch (destinationFormat) {
				case "rdfxml":
					OWLConverter.main("-rdfxml", sourceFileName, destinationFilePath);
					break;
				case "owlxml":
					OWLConverter.main("-owlxml", sourceFileName, destinationFilePath);
					break;
				case "turtle":
					OWLConverter.main("-turtle", sourceFileName, destinationFilePath);
					break;
				case "manchester":
					OWLConverter.main("-manchester", sourceFileName, destinationFilePath);
					break;
				case "fss":
					OWLConverter.main("-fss", sourceFileName, destinationFilePath);
					break;
				case "latex":
					OWLConverter.main("-latex", sourceFileName, destinationFilePath);
					break;
			}
		} catch (Exception e) {
			System.err.println("Exception occured during conversion.");
		}

		return destinationFileName;
	}
}
