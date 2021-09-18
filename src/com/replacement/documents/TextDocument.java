package com.replacement.documents;

public class TextDocument extends Document {

	public TextDocument() {
		super();
	}

	public TextDocument(String content) {
		super(content);
	}

	@Override
	public boolean search(String oldString) {
		return this.getContent().contains(oldString);
	}

	@Override
	public void replace(String oldString, String newString) {
		if (this.search(oldString)) {
			String oldContent = this.getContent();

			// Replace oldString with newString in the newContent
			String newContent = oldContent.replaceAll(oldString, newString);

			// Update class attributes
			this.setContent(newContent);
			this.setLength(newContent.length());
		}
	}
}