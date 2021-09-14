package com.replacement.documents;

public class TextDocument extends Document {

	public TextDocument() {
		super();
		this.setType("txt");
	}

	public TextDocument(String filePath) {
		super(filePath);
		this.setType("txt");
	}

	@Override
	public boolean search(String oldString) {
		return this.getContent().contains(oldString);
	}

	@Override
	public void replace(String oldString, String newString) {
		if (this.search(oldString)) {
			String oldContent = this.getContent();

			// Replacing oldString with newString in the newContent
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Update class attributes 
			this.setContent(newContent);
			this.setLength(newContent.length());

			// Write to standard output
			System.out.println(newContent);

		} else {
			// Write to standard output
			System.out.println(this.getContent());
		}
	}
}