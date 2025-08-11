package com.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {
private	final static String FILE_NAME	 = "notes.txt";


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		while(running) {
			System.out.println("******Notes Manager**********");
			System.out.println("1.Add a Note");
			System.out.println("2.View All Notes");
			System.out.println("3.Exit");
			System.out.println("Enter Your Choice :");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1 :
				addNote(sc);
				break;
			case 2 :
				viewNotes();
				break;
			case 3 :
				running = false;
				System.out.println("Existing...... Good Bye!!!");
			break;
			default:
				System.out.println("Invalid Choice !Please Try Again");
				
			
			}
		}
	}
		private static void addNote(Scanner sc) {
			System.out.println("Enter your note :");
			String note = sc.nextLine();
			try
				(FileWriter fw = new FileWriter(FILE_NAME,true);
					 BufferedWriter bw = new BufferedWriter(fw)) {
				  bw.write(note);
		            bw.newLine();
		            System.out.println("Note added successfully!");

					
				
			}catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
		

	}
		private static void viewNotes() {
	        File file = new File(FILE_NAME);

	        if (!file.exists()) {
	            System.out.println("No notes found.");
	            return;
	        }

	        System.out.println("\n----- Your Notes -----");
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            int count = 1;
	            while ((line = br.readLine()) != null) {
	                System.out.println(count + ". " + line);
	                count++;
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }	

}
