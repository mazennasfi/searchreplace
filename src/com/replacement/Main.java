package com.replacement;

import com.replacement.documents.Document;
import com.replacement.documents.DocumentFactory;

public class Main {

	public static void main(String[] args) {
		
		// Create Document factory
		DocumentFactory documentFactory = new DocumentFactory();

		// Read the file content from standard input
		String content = Document.read();

		// Program's parameters
		String fileDataType = args[0];
		String oldString = args[1];
		String newString = args[2];

		// Generate object of concrete document classes based on fileDataType
		Document document = documentFactory.getDocument(fileDataType, content);

		// Replace the old string with the new string
		document.replace(oldString, newString);

		// Write to standard output
		document.write();
	}
}