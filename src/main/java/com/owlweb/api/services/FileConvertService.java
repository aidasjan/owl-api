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
			String saveFolder = ""; // FIXME where do we save converted files??


			switch (destinationFormat) {
				case "rdfxml":
					destinationFileName = saveFolder+bareFileName+".rdf";
					OWLConverter.main("-rdfxml", sourceFileName, destinationFileName);
					break;
				case "owlxml":
					destinationFileName = saveFolder+bareFileName+".owx";
					OWLConverter.main("-owlxml", sourceFileName, destinationFileName);
					break;
				case "turtle":
					destinationFileName = saveFolder+bareFileName+".ttl";
					OWLConverter.main("-turtle", sourceFileName, destinationFileName);
					break;
				case "manchester":
					destinationFileName = saveFolder+bareFileName+".omn";
					OWLConverter.main("-manchester", sourceFileName, destinationFileName);
					break;
				case "fss":
					destinationFileName = saveFolder+bareFileName+".ofn";
					OWLConverter.main("-fss", sourceFileName, destinationFileName);
					break;
				case "latex":
					destinationFileName = saveFolder+bareFileName+".tex";
					OWLConverter.main("-latex", sourceFileName, destinationFileName);
					break;
			}
		} catch (Exception e) {

		}

		// Return converted file name
		return destinationFileName;
	}
}
