import java.util.Scanner;
public class ProbK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int exp = scn.nextInt();
		int rank = scn.nextInt();
		
		double prob = 0;
		
//		prob = (rank - 1) / (Math.pow(2, exp) - 1);
		
		prob = (Math.pow(2, exp) - rank) / (Math.pow(2, exp) - 1);
		
		for(int i = 0; i < Math.pow(2, exp); i++) {
			
		}
	}

}
