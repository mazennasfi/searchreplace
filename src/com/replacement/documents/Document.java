package com.replacement.documents;

import java.io.BufferedInputStream;
import java.util.Scanner;

public abstract class Document {

	private String content;
	private int length;

	public abstract boolean search(String oldString);

	public abstract void replace(String oldString, String newString);

	public Document() {
		super();
	}

	public Document(String content) {
		super();
		this.content = content;
		this.length = content.length();
	}

	public static String read() {

		// Read the file content from standard input
		String content = "";
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		while (stdin.hasNext()) {
			content += stdin.nextLine() + System.lineSeparator();
		}
		stdin.close();
		return content;
	}

	public void write() {
		// Write to standard output
		System.out.println(content);
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