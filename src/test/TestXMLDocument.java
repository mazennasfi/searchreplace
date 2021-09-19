package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.replacement.documents.XMLDocument;

public class TestXMLDocument {
	
	@Test
	public void testSearchInComment() {
		String inputContent = "<properties>\n" + "<!-- <profiler mode=\"trace\"/> -->\n" + "</properties>";
		XMLDocument xmlDocumentInput = new XMLDocument(inputContent);
		boolean exist = xmlDocumentInput.search("trace");
		assertEquals(exist, false);
	}

	@Test
	public void testSearchInNodeContent() {
		String inputContent = "<message>Level can be either \"trace\", \"info\" or \"error\".</message>";
		XMLDocument xmlDocumentInput = new XMLDocument(inputContent);
		boolean exist = xmlDocumentInput.search("trace");
		assertEquals(exist, false);
	}

	@Test
	public void testSearchInAttributeName() {
		String inputContent = "<message trace=\"value\">Level can be either \"trace\", \"info\" or \"error\".</message>";
		XMLDocument xmlDocumentInput = new XMLDocument(inputContent);
		boolean exist = xmlDocumentInput.search("trace");
		assertEquals(exist, false);
	}

	@Test
	public void testSearchInAttributeValue() {
		String inputContent = "<log level=\"trace\"><file name=\"trace-20180101.log\"/></log>";
		XMLDocument xmlDocumentInput = new XMLDocument(inputContent);
		boolean exist = xmlDocumentInput.search("trace");
		assertEquals(exist, true);
	}
}