package com.accenture.adf.newcodington.module18.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Topic: Reading from the Keyboard and Writing to the Console 
 * 
 * Description:
 * 
 * Wrapping System.in with an instance of InputStreamReader allows us to read the entries as characters and
 * wrapping the InputStreamReader with a BufferedReader allows the reading and buffering of multiple characters and lines of text.
 * 
 */

public class ConsoleIO {

	
	public static void main(String[] args) throws IOException {
	System.out.println("Enter a string: ");
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line;
	while((line=in.readLine())!=null&&(line.length()!=0))
	{
		System.out.println("You Entered : "+line);
	}

	}

}
