import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/* Max Aaronson
 * CS342
 * Project 3
 * 11/30/15
 */

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		Scanner in = null;
		int c;
		String s;
		int totalWordCount = 0;
		
		BinaryTree tree = new BinaryTree();
		
		String line = null;
		
		s = System.getProperty("user.dir") + "\\src\\dracula.txt";  // gives path to file
		
		File file = new File(s);
		String words[] = null;
		
		try {
			in = new Scanner(file);
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				
				line = line.replaceAll("[^a-zA-Z0-9\\s]", "");  // remove non-alpha-numerics, leave spaces
				line = line.replaceAll("\n", " ");  // replace newline chars with spaces
				line = line.toLowerCase();
				
				 words = line.split(" ");  // split line up with spaces as delimiter
				for (String i: words){
					if (i.compareTo("") != 0){  // filter out empty strings
						tree.add(i);
						totalWordCount++;
					}
				}
			}
			
			
		}
		catch (Exception e){
			System.out.println("error");
		}
		finally {
			if (in != null){
				in.close();
			}
		}

		System.out.println("Total word count: " + totalWordCount);
		System.out.println("Word at root: " + tree.getRoot().getWord());
		System.out.println("Depth of tree: " + tree.findDepth());
		String t = tree.getDeepestWord(tree.getRoot(), 0);
		System.out.println("Deepest word is: " + t);

		System.out.println("transylvania occurs " + tree.getWordFrequency("transylvania") + " times");
		System.out.println("harker occurs " + tree.getWordFrequency("harker") + " times");
		System.out.println("renfield occurs " + tree.getWordFrequency("renfield") + " times");
		System.out.println("vampire occurs " + tree.getWordFrequency("vampire") + " times");
		System.out.println("expostulate occurs " + tree.getWordFrequency("expostulate") + " times");
		System.out.println("Unique words: " + tree.getNodeCount());
		tree.mostFrequentWord();
	}

}
