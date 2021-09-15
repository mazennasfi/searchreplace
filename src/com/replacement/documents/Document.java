package com.replacement.documents;

import java.util.Scanner;

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
	}
	
	public static String read() {
		//Read the file path from standard input
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.next();
		scanner.close();
		return filePath;
	}
	
	public void write() {
		//Write to standard output
		System.out.println(content);
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