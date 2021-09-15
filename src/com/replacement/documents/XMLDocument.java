package com.replacement.documents;

import java.io.File;	
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDocument extends Document {
	
	private org.w3c.dom.Document document;

	public XMLDocument() {
		super();
		this.setType("xml");
	}

	public XMLDocument(String filePath) {
		super(filePath);
		this.setType("xml");

		try {
			//Build the doc from the XML file path
			org.w3c.dom.Document documentCreated = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File(filePath));
			documentCreated.getDocumentElement().normalize();
			document = documentCreated;

			this.setContent(this.toString());
			this.setLength(this.toString().length());

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean search(String oldString) {

		//Store all the xml document element nodes in nodeList
		NodeList nodeList = document.getElementsByTagName("*");

		boolean exists = false;
		//Browse all the element nodes of the xml document
		int node = 0;
		while (node < nodeList.getLength() && exists == false) {

			//In case of multiple attributes in a single element node
			//Browse all the attributes
			for (int attribute = 0; attribute < nodeList.item(node).getAttributes().getLength(); attribute++) {

				//Test the existence of old string in the attribute value 
				//and replace if it exists
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

			//Store all the xml document element nodes in nodeList
			NodeList nodeList = document.getElementsByTagName("*");

			//Browse all the element nodes of the xml document
			for (int node = 0; node < nodeList.getLength(); node++) {
				//In case of multiple attributes in a single element node
				//Browse all the attributes
				for (int attribute = 0; attribute < nodeList.item(node).getAttributes().getLength(); attribute++) {

					//Test the existence of old string in the attribute value 
					//and replace if it exists
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

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		try {
		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(new DOMSource(document), new StreamResult(sw));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
}