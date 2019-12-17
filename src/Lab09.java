// Abdul Khan
// C block
// 1/28/19

package Lab09;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
public class Lab09 {

	public static void main(String[] args) {
		int repeat = 0;
		displayLongestWord();
		putInArray();
		do{
			grep();
			repeat++;
		}while(repeat < 3);
	}
	public static void displayLongestWord() {
		String pathname = "Cabbages.txt";
		    File file = new File(pathname);
		    Scanner input = null;
		    try
		    {
		        input = new Scanner(file);
				
		        System.out.println("Words found in text --");
				int count = 0;
				String longestWord = "";
				while(input.hasNext()) {
					count++;
					String word = input.next();
					if(word.length() > longestWord.length()) {
						longestWord = word;
					}
					System.out.println(count+" "+word);
				}
				System.out.println("The longest word in the text is <"+longestWord+">.\n\n");
		    }
		    catch (FileNotFoundException ex)
		    {
		        System.out.println("*** Cannot open " + pathname + " ***");
		        System.exit(1);  // quit the program
		    } 
	}
	public static void putInArray() {
		
		String pathname = "Cabbages.txt";
	    File file = new File(pathname);
	    Scanner input = null;
	    try
	    {	System.out.println("Words sorted alphabetically with duplicates removed --");

	        input = new Scanner(file);
	        
	        String[] array = new String[609];
	        int counter = 0;
	        while(input.hasNext()) {
	        	String word = input.next();
	        	int start = 0, end = word.length() - 1;
	        	for(int i = 0; i < word.length(); i ++) {
	        	if(word.charAt(start) == ',' || word.charAt(start) == '.' || word.charAt(start) == ',' ||word.charAt(start) == '-' ||word.charAt(start) == '"' ||word.charAt(start) == '!' || word.charAt(start) == '?' ||word.charAt(start) == ';' ||word.charAt(start) == ':' || word.charAt(start) == '\'') {
	        		start++;
	        	}
	        	}
	        	for(int j = word.length(); j > 0; j--) {
		        	if(word.charAt(end) == ',' || word.charAt(end) == '.' || word.charAt(end) == ',' ||word.charAt(end) == '-' ||word.charAt(end) == '"' ||word.charAt(end) == '!' || word.charAt(end) == '?' ||word.charAt(end) == ';' ||word.charAt(end) == ':' || word.charAt(start) == '\'') {
		        		end--;
		        	}
		        	}
	        	word = word.substring(start,end+1);
	        	String finalWord = word.toLowerCase();
	        	array[counter] = finalWord;
	        	counter++;
	        }
	        Arrays.sort(array);
	        int duplicate = 0;
	        for(int i = 0; i < array.length-1; i++) {
	        	if(array[i].equals(array[i+1])) {
	        		array[i] = "z";
	        		duplicate++;
	        	}
	        }
	        Arrays.sort(array);
	        String[] finalArray = new String[array.length-duplicate];
	        for(int i = 0; i < finalArray.length; i++) {
	        	finalArray[i] = array[i];
	        	}
	        
	        for(int i = 0; i < finalArray.length; i++) {
	        	System.out.println(i+" "+finalArray[i]);
	        }
	    }
	
	    catch (FileNotFoundException ex)
	    {
	   		System.out.println("*** Cannot open " + pathname + " ***");
	   		System.exit(1);  // quit the program
	    } 
			}
	
// 	public static void grep() {
		
		
// 		String pathname = "Cabbages.txt";
// 	    File file = new File(pathname);
// 	    String sub = "";
// 		Scanner input = null;
// 		boolean found = false;
// 		try
// 		    {
// 		        input = new Scanner(file);
// 				int lineNumber = 1;
// 		        Scanner take = new Scanner(System.in);
// 		        System.out.println("Please enter something to grep: ");
// 		        String searchFor = take.next();
// 		        int length = searchFor.length();
// 		        while(input.hasNextLine()) 
// 		        {
// 		        	String line = input.nextLine();
// 		        	for(int i = 0; i < line.length() - (length+1); i ++) {
		        		
// 		        		sub = line.substring(i, length+i);
// 		        		if(sub.equals(searchFor)) {
		        			
// 		        			String first = line.substring(0,i);
// 		        			String middle = line.substring(i, length+i);
// 		        			String last = line.substring(length+i, line.length());
// 							System.out.println("Line " + lineNumber + ": " + first + "<" + middle + ">" + last);
// 							found = true;
// 		        		}
// 		        	}
// 		        	lineNumber++;
// 		        }
// 		        if(found == false) {
// 		        	System.out.println("Your phrase was not found.");
// 		        }
// 		    }
// 		    catch (FileNotFoundException ex)
// 		    {
// 		        System.out.println("*** Cannot open " + pathname + " ***");
// 		        System.exit(1);  // quit the program
// 		    } 
// 	}
	
// 				}




