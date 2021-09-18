package com.replacement.documents;

import java.io.StringReader;	
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLDocument extends Document {

	private org.w3c.dom.Document document;

	public XMLDocument() {
		super();

	}

	public XMLDocument(String content) {
		super(content);
		document = createXMLDocumentFromString(content);
	}

	@Override
	public boolean search(String oldString) {

		// Store all the xml document element nodes in nodeList
		NodeList nodeList = document.getElementsByTagName("*");

		boolean exists = false;
		// Browse all the element nodes of the xml document
		int node = 0;
		while (node < nodeList.getLength() && exists == false) {

			// In case of multiple attributes in a single element node
			// Browse all the attributes
			for (int attribute = 0; attribute < nodeList.item(node).getAttributes().getLength(); attribute++) {

				// Test the existence of old string in the attribute value
				// and replace if it exists
				String attributeValue = nodeList.item(node).getAttributes().item(attribute).getNodeValue();
				if (attributeValue.contains(oldString)) {
					exists = true;
				}
			}
			node++;
		}
		return exists;
	}

	@Override
	public void replace(String oldString, String newString) {

		if (this.search(oldString)) {

			// Store all the xml document element nodes in nodeList
			NodeList nodeList = document.getElementsByTagName("*");

			// Browse all the element nodes of the xml document
			for (int node = 0; node < nodeList.getLength(); node++) {
				// In case of multiple attributes in a single element node
				// Browse all the attributes
				for (int attribute = 0; attribute < nodeList.item(node).getAttributes().getLength(); attribute++) {

					// Test the existence of old string in the attribute value
					// and replace if it exists
					String attributeValue = nodeList.item(node).getAttributes().item(attribute).getNodeValue();
					if (attributeValue.contains(oldString)) {
						nodeList.item(node).getAttributes().item(attribute)
								.setNodeValue(attributeValue.replaceAll(oldString, newString));
					}
				}
			}
			this.setContent(this.toString());
			this.setLength(this.toString().length());
		}

	}

	public org.w3c.dom.Document getDocument() {
		return document;
	}

	public void setDocument(org.w3c.dom.Document document) {
		this.document = document;
	}

	// Return org.w3c.dom.Document content
	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		try {
			// Transformer performs a copy from source to a result
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(document), new StreamResult(sw));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	public org.w3c.dom.Document createXMLDocumentFromString(String content) {
		try {

			// Parser that produces DOM object trees from XML content
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// API to obtain DOM Document instance
			// Create DocumentBuilder with default configuration
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			org.w3c.dom.Document documentCreated = builder.parse(new InputSource(new StringReader(content)));
			return documentCreated;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}