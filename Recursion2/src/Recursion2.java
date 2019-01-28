/*
 * Max Aaronson
 * CS342
 * HW3
 * Problem 2
 */

public class Recursion2 {

	public static void main(String[] args) {
		
		Recursion2 r = new Recursion2();
		r.run();

	}
	
	public void run(){
		int a = convert("1234");
		System.out.println(a);
		System.out.println(convert("3945"));
		System.out.println(convert("063"));
	}
	
	public int convert(String s){
		if (s.length()==1){
			char l = s.charAt(0);  // grab first char in string
			int m = l - '0';  // convert char to int
			return m;
		}
		else {
			char l = s.charAt(s.length()-1);
			int m = l - '0';
			s = s.substring(0, s.length()-1);
			return m + 10*(convert(s));
		}
	}

}
