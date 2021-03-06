import java.util.Scanner;
import java.io.*;

public class ScoreResultTransfer
{
	public static void main(String[] args) throws IOException
	{
	String inputFilename;
	String outputFilename;
	String input;
	String output;
	String answer;
	double number;
	double highest = 0;
	double lowest = 100;
	double total = 0;
	double average = 0;
	int numlines = 1;	

	//Create Scanner for keyboard input.	
	Scanner keyboard = new Scanner(System.in);
	
	//Get input filename.
	System.out.print("Enter input score file: ");
	inputFilename = keyboard.nextLine();
	
	//Get output filename.
	System.out.print("Enter output score file name: ");
	outputFilename = keyboard.nextLine();

	//Open input file.	
	File file = new File(inputFilename);
	Scanner inputFile = new Scanner(file);
	
	number = inputFile.nextDouble();
	
	if (number > highest && number > 0)
	{
	highest = number;
	numlines++;
	}
		
	else if (number < lowest && number > 0)
	{
	lowest = number;
	numlines++;
	}
	
	else if (number >=0)
	{
	total += number;
	numlines++;
	}
	
	else
	{
	System.out.println("Negative numbers are not counted.");
	}
	
	average = total / numlines;

	//Open output file and write items.
	PrintWriter outputFile = new PrintWriter(outputFilename);
	if (total > 0)
	{
		System.out.println("Highest: " + highest);
		System.out.println("Lowest: " + lowest);
		System.out.println("Total: " + total);
		System.out.println("Average: " + average);
	}
	else
		System.out.println("There are no valid scores in input.");

	//Close files.
	inputFile.close();
	outputFile.close();
}

}
