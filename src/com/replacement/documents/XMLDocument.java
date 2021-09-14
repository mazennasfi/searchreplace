package com.replacement.documents;

import java.io.BufferedReader;	
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XMLDocument extends Document {

	public XMLDocument() {
		super();
		this.setType("xml");
	}

	public XMLDocument(String filePath) {
		super(filePath);
		this.setType("txt");
	}

	@Override
	public boolean search(String oldString) {
		String[] lines = this.getContent().split(System.getProperty("line.separator"));
		boolean exists = false;
		int index = 0;

		while (index < lines.length) {
			if (!(lines[index].contains("<!--")) && (!lines[index].contains("<comment>"))
					&& (lines[index].contains(oldString))) {
				exists = true;
				break;
			} else {
				index++;
			}
		}
		return exists;
	}

	@Override
	public void replace(String oldString, String newString) {
		if (this.search(oldString)) {
			String content = "";
			String filePath = this.getFilePath();
			File fileToBeModified = new File(filePath);
			BufferedReader reader = null;

			try {
				reader = new BufferedReader(new FileReader(fileToBeModified));

				// Reading the input xml file line by line into line variable
				String line = reader.readLine();

				while (line != null) {
					// Don't replace old content in comment bloc or comment nodes
					if (!(line.contains("<!--")) && (!line.contains("<comment>"))) {
						String newLine = line.replaceAll(oldString, newString);
						content = content + newLine + System.lineSeparator();
					} else {
						content = content + line + System.lineSeparator();
					}
					line = reader.readLine();
				}
				
				//Update class attributes 
				this.setContent(content);
				this.setLength(content.length());

				// Write to standard output
				System.out.println(content);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// Closing the resources
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			// Write to standard output
			System.out.println(this.getContent());
		}
	}
}