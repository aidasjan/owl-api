package com.owlweb.api.services;

import org.springframework.stereotype.Service;
import org.apache.commons.io.FilenameUtils;
import sk.matfyz.owltoolkit.OWLMerger;

@Service
public class FileMergeService {
	public String mergeFiles(String destinationFileName, String ...sourceFileNames) {
		// Merge files
		String[] arguments = new String[sourceFileNames.length + 1];
		arguments[0] = "uploads/"+destinationFileName;
		for (int i=1; i<arguments.length; i++) arguments[i] = sourceFileNames[i-1];

		try {
			OWLMerger.main(arguments);

		} catch (Exception e) {
			System.err.println("Exception occured during merging.");
		}

		// Return merged file name
		return destinationFileName;
	}
}
