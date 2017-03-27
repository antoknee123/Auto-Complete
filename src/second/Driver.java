package second;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Driver {

	public static void main(String[] args) {
		 // read in the terms from a file
		  try{
				/// Create a File instance
			    java.io.File file = new java.io.File("src/second/cities.txt");
			    
			    // Create a Scanner for the file
			    Scanner input = new Scanner(file, "UTF-8");
			    // Read data from a file
			    int N = input.nextInt();
			    Term[] terms = new Term[N];
			    for(int i = 0; i<N; i++)
			    {
				    double weight = input.nextDouble();       // read the next weight
				      // scan past the tab
				    input.useDelimiter(Pattern.compile(""));
			        String ch = input.next();
			        assert (ch.length() == 1) : "Internal (Std)In.readChar() error!"
			           + " Please contact the authors.";
			        input.useDelimiter(Pattern.compile("\\p{javaWhitespace}+"));
			        ch.charAt(0);
			     // read the next query
				    String query = input.nextLine();        
				    terms[i] = new Term(query, weight); 
			    }
			 // read in queries from standard input and print out the top k matching terms
			    int k = 5;//Integer.parseInt(args[1]);
			    Autocomplete autocomplete = new Autocomplete(terms);
			    int num = autocomplete.allMatches("Ch");
			    int repeat = k<num ? k: num;
			    int results = autocomplete.allMatches("Ch");
			    for(int i=0; i<repeat; i++ )
			    {
			  	  System.out.println(results[i]);
			    }
			    // Close the file
			    input.close();
			    
				}
			catch (FileNotFoundException ex)
			{
				System.out.print(ex.toString());
			}
	}

}
