package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLDeclarations;

@Service
public class GetDeclarationsService {
	public String getDeclarations(String sourceFileName) {
		String destinationFileName = java.util.UUID.randomUUID().toString();
		String destinationFilePath = "uploads/" + destinationFileName;

		try {
			OWLDeclarations.main(sourceFileName, destinationFilePath);
		} catch (Exception e) {
			System.out.println("Exception occurred while getting declarations.");
		}

		return destinationFileName;
	}
}
