package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLIndividuals;

@Service
public class GetIndividualsService {
	public String getIndividuals(String sourceFileName) {
		String destinationFileName = "individuals_"+sourceFileName;
		try {
			String bareFileName = FilenameUtils.removeExtension(sourceFileName);
			OWLIndividuals.main("uploads/"+sourceFileName, "uploads/"+destinationFileName);
		} catch (Exception e) {
			System.err.println("Exception occured while getting individuals.");
		}

		return destinationFileName;
	}
}
