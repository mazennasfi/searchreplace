package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import com.replacement.documents.TextDocument;

public class TestTextDocument {

	@Test
	public void testReplace() {

		String inputFilePath = "test.txt";
		String expectedFilePath = "result.txt";
		TextDocument inputTextDocument = new TextDocument(inputFilePath);
		TextDocument expectedTextDocument = new TextDocument(expectedFilePath);

		inputTextDocument.replace("customer", "client");

		assertEquals(inputTextDocument.getContent(), expectedTextDocument.getContent());
	}
}