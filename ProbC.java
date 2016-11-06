import java.util.Arrays;
import java.util.Scanner;
public class ProbC {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int houses = scn.nextInt();
		int cameras = scn.nextInt();
		int range = scn.nextInt();
		
		boolean[] arr = new boolean[houses];
		
		for (int i = 0; i < arr.length; i++){
			arr[i] = false;
		}
		
		for (int i = 0; i < cameras; i++ ){
			int camera = scn.nextInt();
			arr[camera - 1] = true;
			
		// data done	
		}
		
		//range
		
		
		int count = 0;
		int total = 0;
		
		
		for(int i = 0; i < range; i++) {
			if (arr[i]) {
				count++; // saw a camera
			}
		}
		
		for(int i = range; i < houses; i++ ) {

			
			if (count == 0) {
				int back = i-1;
				int found = 0;
				while (back >= i - range && found < 2) {
					if(!arr[back]) {
						arr[back] = true;
						found++;
					}
					back--;
				}
				total += 2;
				count += 2;
			}
			else if (count == 1) {
				int back = i - 1;
				int found = 0;
				while (back >= i - range && found < 1) {
					if(!arr[back]) {
						arr[back] = true;
						found++;
					}
					back--;
				}
				total += 1;
				count += 1;
			}
			
			if(arr[i]) {
				count++;	
			}

			if(arr[i - range]) { // if you move the camera to the beginning, then a camera was already set
				count--;
			}
			
		}
		if (count == 0) {
			int back = houses-1;
			int found = 0;
			while (back >= houses - range && found < 2) {
				if(!arr[back]) {
					arr[back] = true;
					found++;
				}
				back--;
			}
			total += 2;
			count += 2;
		}
		else if (count == 1) {
			int back = houses - 1;
			int found = 0;
			while (back >= houses - range && found < 1) {
				if(!arr[back]) {
					arr[back] = true;
					found++;
				}
				back--;
			}
			total += 1;
			count += 1;
		}
		System.out.println(total);
//		System.out.println(Arrays.toString(arr));
		
		

	}

}
