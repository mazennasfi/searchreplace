package com.replacement.documents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Document {

	private String type;
	private String filePath;
	private String content;
	private int length;

	public abstract boolean search(String oldString);

	public abstract void replace(String oldString, String newString);

	public Document() {
		super();
	}

	public Document(String filePath) {
		super();
		this.filePath = filePath;
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try { // Closing the resources
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.content = content;
		this.length = content.length();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}