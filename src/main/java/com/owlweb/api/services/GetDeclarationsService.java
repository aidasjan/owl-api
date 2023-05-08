package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLDeclarations;

@Service
public class GetDeclarationsService {
	public String getDeclarations(String sourceFileName) {
		String destinationFileName = "declarations_"+sourceFileName;
		try {
			String bareFileName = FilenameUtils.removeExtension(sourceFileName);
			OWLDeclarations.main("uploads/"+sourceFileName, "uploads/"+destinationFileName);
		} catch (Exception e) {
			System.out.println("Exception occured while getting declarations.");
		}

		return destinationFileName;
	}
}
