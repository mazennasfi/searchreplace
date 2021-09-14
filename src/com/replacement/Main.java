package com.replacement;

import java.util.Scanner;
import com.replacement.documents.TextDocument;
import com.replacement.documents.XMLDocument;

public class Main {

	static void searchreplace(String fileDataType, String oldString, String newString) {

		// Read the file path from standard input
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.next();
		
		if (fileDataType.equals("xml")) {
			XMLDocument xmlDocument = new XMLDocument(filePath);
			xmlDocument.replace(oldString, newString);
		} 
		else if (fileDataType.equals("txt")) {
			TextDocument textDocument = new TextDocument(filePath);
			textDocument.replace(oldString, newString);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		searchreplace("xml", "client", "error");
	}
}