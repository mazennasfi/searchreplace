package com.replacement.documents;

import java.io.BufferedReader;	
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextDocument extends Document {

	public TextDocument() {
		super();
		this.setType("txt");
	}

	public TextDocument(String filePath) {
		super(filePath);
		this.setType("txt");
		File file = new File(filePath);
		String content = "";
		BufferedReader reader = null;

		try {
			// Enter data using BufferReader
			reader = new BufferedReader(new FileReader(file));

			// Reading data using readLine
			String line = reader.readLine();

			while (line != null) {
				content = content + line + System.lineSeparator();
				line = reader.readLine();
			}
			this.setContent(content);
			this.setLength(content.length());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try { //Close the resources
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public boolean search(String oldString) {
		return this.getContent().contains(oldString);
	}

	@Override
	public void replace(String oldString, String newString) {
		if (this.search(oldString)) {
			String oldContent = this.getContent();

			//Replace oldString with newString in the newContent
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Update class attributes 
			this.setContent(newContent);
			this.setLength(newContent.length());
		}
	}
}