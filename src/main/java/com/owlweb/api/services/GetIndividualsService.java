package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLIndividuals;

@Service
public class GetIndividualsService {
	public String getIndividuals(String sourceFileName) {
		String destinationFileName = java.util.UUID.randomUUID().toString();
		String destinationFilePath = "uploads/" + destinationFileName;

		try {
			OWLIndividuals.main(sourceFileName, destinationFilePath);
		} catch (Exception e) {
			System.err.println("Exception occured while getting individuals.");
		}

		return destinationFileName;
	}
}
