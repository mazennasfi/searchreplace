package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.replacement.documents.TextDocument;

public class TestTextDocument {

	@Test
	public void testReplace() {

		String inputContent = "Our highest priority is to satisfy the customer\n"
				+ "through early and continuous delivery\n" + "of valuable software.\n" + "\n" + "\n"
				+ "Welcome changing requirements, even late in\n" + "development. Agile processes harness change for\n"
				+ "the customer's competitive advantage.";
		String expectedContent = "Our highest priority is to satisfy the client\n"
				+ "through early and continuous delivery\n" + "of valuable software.\n" + "\n" + "\n"
				+ "Welcome changing requirements, even late in\n" + "development. Agile processes harness change for\n"
				+ "the client's competitive advantage.";

		TextDocument inputTextDocument = new TextDocument(inputContent);
		TextDocument expectedTextDocument = new TextDocument(expectedContent);
		inputTextDocument.replace("customer", "client");

		assertEquals(inputTextDocument.getContent(), expectedTextDocument.getContent());
	}
}