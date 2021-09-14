package com.replacement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	static void searchreplace(String fileDataType, String oldString, String newString) {
		
		Scanner scanner = new Scanner(System.in);	
		
		if (fileDataType.equals("xml")) {
			
			String filePath = scanner.next();

			File fileToBeModified = new File(filePath);

			String oldContent = "";

			BufferedReader reader = null;

			FileWriter writer = null;

			try {
				reader = new BufferedReader(new FileReader(fileToBeModified));
				
				// Reading the input xml file line by line into line variable

				String line = reader.readLine();

				while (line != null) {
					
					
					
					if (!(line.contains("<!--")) && (!line.contains("<comment>"))) {
						
						// Don't replace old content in comment bloc or comment nodes
						
						String newLine = line.replaceAll(oldString, newString);
						
						oldContent = oldContent + newLine + System.lineSeparator();

					} else {
						
						oldContent = oldContent + line + System.lineSeparator();

					}
					line = reader.readLine();

				}
		
				// Rewriting the input xml file with newContent

				writer = new FileWriter(fileToBeModified);
				
			    
				writer.write(oldContent);
				
				// Outputing the xml result into console
				
				System.out.println(oldContent);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// Closing the resources

					reader.close();

					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else if (fileDataType.equals("txt")){

			String filePath = scanner.next();

			File fileToBeModified = new File(filePath);

			String oldContent = "";

			BufferedReader reader = null;

			FileWriter writer = null;

			try {

				// Enter data using BufferReader
				
				reader = new BufferedReader(new FileReader(fileToBeModified));

				// Reading data using readLine

				String line = reader.readLine();

				while (line != null) {
					oldContent = oldContent + line + System.lineSeparator();

					line = reader.readLine();
				}

				// Replacing oldString with newString in the newContent

				String newContent = oldContent.replaceAll(oldString, newString);

				writer = new FileWriter(fileToBeModified);
				
				// Rewriting the input text file with newContent
				
				writer.write(newContent);

				System.out.println(newContent);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try { // Closing the resources

					reader.close();

					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		searchreplace("txt", "customer", "client");

	}
}