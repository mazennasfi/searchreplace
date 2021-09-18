package com.replacement.documents;

public class DocumentFactory {

	public DocumentFactory() {
		super();
	}

	// Create a getDocument method to generate object of concrete document classes
	// based on fileDataType
	public Document getDocument(String fileDataType, String content) {
		if (fileDataType == null) {
			return null;
		}
		if (fileDataType.equalsIgnoreCase("txt")) {
			return new TextDocument(content);
		} else if (fileDataType.equalsIgnoreCase("xml")) {
			return new XMLDocument(content);
		}
		return null;
	}
}
