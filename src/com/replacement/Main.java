package com.replacement;

import com.replacement.documents.Document;
import com.replacement.documents.TextDocument;
import com.replacement.documents.XMLDocument;

public class Main {

	public static void main(String[] args){
		
		String fileDataType = args[0];
		String oldString = args[1];
		String newString = args[2];

		//Read the file path from standard input
		String filePath = Document.read();

		switch (fileDataType) {
		case "txt":
			TextDocument textDocument = new TextDocument(filePath);
			textDocument.replace(oldString, newString);
			//Write to standard output
			textDocument.write();
			break;
		case "xml":
			XMLDocument xmlDocument = new XMLDocument(filePath);
			xmlDocument.replace(oldString, newString);
			//Write to standard output
			xmlDocument.write();
			break;
		default:
			System.out.println("specify another data type : try txt or xml");
		}
	}
}