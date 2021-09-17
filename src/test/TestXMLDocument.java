package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import com.replacement.documents.XMLDocument;

class TestXMLDocument {

	@Test
	public void testReplace() {

		String inputFilePath = "test.xml";
		String expectedFilePath = "resut.xml";
		XMLDocument xmlDocumentInput = new XMLDocument(inputFilePath);
		XMLDocument xmlDocumentExpected = new XMLDocument(expectedFilePath);

		xmlDocumentInput.replace("trace", "error");

		assertEquals(xmlDocumentInput.getContent(), xmlDocumentExpected.getContent());
	}
}