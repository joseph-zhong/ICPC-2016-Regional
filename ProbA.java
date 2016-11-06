import java.util.Scanner;

public class ProbA {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
				
		char[] arr = new char[26];
		
		int min = Integer.MAX_VALUE;
		
		
		
		for(int j = 0; j < str.length(); j++) {
			int currI = 0; // letter we're looking at in the string
			
			
			
			for (int i = j; i < str.length(); i++ ) {
				char g = str.charAt(i);
				if (currI == 0) { // if equal then add to array
					arr[currI] = g;
					currI++;
				}
				else {
					if (g > arr[currI - 1]) { // more than so just add
						arr[currI++] = g;
					}				
					else { // smaller so check displacement
						if (currI == 1) { // first thing so replace first
							arr[currI - 1] = g;
						}
						else {
							// greater, needs displacement check
							if (g > arr[currI - 2]) {
								arr[currI - 1] = g;
							}
						}
					}
				}	
			}	
			if (26 - currI < min) {
				min = 26 -currI;
			}
		}
		
		System.out.println(min);

	}

}
