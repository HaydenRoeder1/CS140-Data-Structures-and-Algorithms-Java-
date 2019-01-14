package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class FullAssembler implements Assembler{
	public int assemble(String inputFileName, String outputFileName, StringBuilder error) {
		ArrayList<String> codeLines = new ArrayList<String>();
		ArrayList<String> dataLines = new ArrayList<String>();
		ArrayList<Integer> errorLines = new ArrayList<Integer>();
		//ArrayList<String> dataSeparator = new ArrayList<String>();
		File file = new File(inputFileName);
		try {
			Scanner inFile = new Scanner(file);
			boolean readingData = false;
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				if(line.trim().toUpperCase().equals("DATA")) {
					readingData = true;
					//dataSeparator.add(line);
					//line = inFile.nextLine();
				}
				if(readingData)
					dataLines.add(line);
				else 
					codeLines.add(line);
			}	
			inFile.close();
		}catch (FileNotFoundException e){
			System.out.println("Could not find file");
			return -1;
		}
		if(error == null) {
			throw new IllegalArgumentException("Coding error: the error buffer is null");
		}
		boolean blankLineTracker = false;
		boolean blankLineReported = false;
		int blankLine = 0;
		
		//LOOP FOR CODE LINES
		for(int i = 0; i < codeLines.size(); i++) {//i = (line of code - 1)
			String line = codeLines.get(i);
			String[] parts = line.trim().split("\\s+");
			//*CHECKING FOR BLANK LINES*
			if(line.trim().length() == 0) {
				if(blankLineTracker == false) {
					blankLine = i + 1;
					blankLineTracker = true;
				}
			}
			//*CHECKING FOR LINES STARTING WITH WHITE SPACE*
			else if(line.charAt(0) == ' ' || line.charAt(0) == '\t') {
				if(line.trim().length() > 0)
					error.append("\nLine starts with illegal white space");
					errorLines.add(i + 1);
			}
			if(line.trim().length() != 0 && blankLineTracker == true && blankLineReported == false) {
				error.append("\nIllegal blank line in the source file");
				errorLines.add(blankLine); 
				blankLineReported = true;
			}
			//////////////////////////
			


			//////////////////////////
			
			//*CHECKING FOR INVALID OPCODES
			if(!InstrMap.toCode.keySet().contains(parts[0].toUpperCase()) && line.trim().length() != 0) {
				error.append("\nError on line " + (i+1) + ": illegal mnemonic");
				errorLines.add(i+1); 
			}
			if(InstrMap.toCode.keySet().contains(parts[0].toUpperCase())) {
				if(!InstrMap.toCode.keySet().contains(parts[0])) {
					error.append("\nError on line " + (i+1) + ": mnemonic must be upper case");
					errorLines.add(i+1);
				}
				if(parts.length != 2 && !noArgument.contains(parts[0])) {
					error.append("\nError on line " + (i + 1) + ": mnemonic has incorrect number of arguments");
					errorLines.add(i+1); 
				}if(!noArgument.contains(parts[0]) && parts.length == 2) {
					try { int arg = Integer.parseInt(parts[1], 16);}
					catch(NumberFormatException e) {
						error.append("\nError on line " + (i + 1) + ": mnemonic must have numeric argument");
						errorLines.add(i+1);
					}
				}if(noArgument.contains(parts[0]) && parts.length != 1) {
					error.append("\nError on line " + (i+1) + ": this mnemonic has too many arguments");
					errorLines.add(i+1);
				}
			}
		}
		
		//LOOP FOR DATA LINES
		for(int i = 0, j = codeLines.size() + 1; i < dataLines.size(); i++, j++) { //j = line of code
			String line = dataLines.get(i);
			String[] parts = line.trim().split("\\s+");
			if(parts.length != 2 && i != 0 && line.trim().length() > 0) {
				error.append("\nError on line " + (j) + ": data entries must have two parts");
				errorLines.add(j); 
			}
			if(line.trim().length() == 0) {
				if(blankLineTracker == false) {
					blankLine = i + 1;
					blankLineTracker = true;
				}
			}
			//*CHECKING FOR LINES STARTING WITH WHITE SPACE*
			else if(line.charAt(0) == ' ' || line.charAt(0) == '\t') {
				if(line.trim().length() > 0)
					error.append("\nLine starts with illegal white space");
					errorLines.add(i + 1);
			}
			if(line.trim().length() != 0 && blankLineTracker == true && blankLineReported == false) {
				error.append("\nIllegal blank line in the source file");
				errorLines.add(blankLine); 
				blankLineReported = true;
			}
			//////////////////////////
			

			//////////////////////////
			if(i != 0 && line.trim().length() > 0) {
				try { 
					int arg = Integer.parseInt(parts[0],16); 
					int value = Integer.parseInt(parts[1], 16);
				}catch (NumberFormatException e) {
					error.append("\nError on line " + (j) + ": data entries must be numeric");
					errorLines.add(j); //MESSAGE "ARGUMENT AND VALUE MUST BE NUMERIC"
				}
			}
			//*CHECKING FOR DATA SEPARATOR PROBLEMS
			if(line.trim().toUpperCase().equals("DATA") && i != 0) {
				error.append("\nError on line " + (j) + ": program must only have 1 DATA header");
				errorLines.add(j); //MESSAGE "CAN ONLY HAVE 1 DATA SEPARATOR LINE"
			}
			if(line.trim().toUpperCase().equals("DATA") && !line.trim().equals("DATA")) {
				error.append("\nError on line " + (j) + ": DATA header must be uppercase");
				errorLines.add(j); //MESSAGE "DATA SEPARATOR MUST BE UPPERCASE"
			}
			///////////////////////////////////////
		}
		if(errorLines.size() != 0) {
			return errorLines.get(0);
		}else {
				return new SimpleAssembler().assemble(inputFileName, outputFileName, error);
		}
			
	}
	public static void main(String[] args) {
		StringBuilder error = new StringBuilder();
		System.out.println("Enter the name of the file without extension: ");
		try (Scanner keyboard = new Scanner(System.in)) { 
			String filename = keyboard.nextLine();
			int i = new FullAssembler().assemble(filename + ".pasm", 
					filename + ".pexe", error);
			System.out.println("result = " + i);
		}
	}
}
