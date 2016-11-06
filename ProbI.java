import java.util.Arrays;
import java.util.Scanner;
public class ProbI {

	private static class House implements Comparable<House>{

		int location;
		int letters;
		
		public House(int location, int letters) {
			this.location = location;
			this.letters = letters;
			
		}
		
		@Override
		public int compareTo(House o) {
			return Integer.compare(this.location, o.location);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int houses = scn.nextInt();
		long maxCarry = scn.nextLong();
		
//		int[][] arr = new int[houses][2]; 
		
		House[] arr = new House[houses];
		
		for(int i = 0; i < houses; i++) {
			arr[i] = new House(scn.nextInt(), scn.nextInt());
		} // get data
		
		Arrays.sort(arr); // sorted low locations 
		
		int i = 0; // house index
		long steps = 0;
//		long leftover = 0;
		
		while(i < houses && arr[i].location < 0) {
			int trip = 0;
			int location = arr[i].location;
			while(trip < maxCarry && i < houses && arr[i].location < 0) {
				trip += arr[i].letters;
				i++;
			}
			i--;
			
			steps -= 2 * location;
			int dropped = trip - arr[i].letters;
			long leftover = maxCarry - dropped;
			arr[i].letters -= leftover;
			long visits = arr[i].letters / maxCarry;
			steps -= 2 * visits * arr[i].location;
			arr[i].letters -= visits * maxCarry;
			if( arr[i].letters == 0) { 
				i++;
			}
		}
		
		i = houses - 1;
		
		while(i >=  0 && arr[i].location > 0) {
			int trip = 0;
			int location = arr[i].location;
			while(trip < maxCarry && i >=  0 && arr[i].location > 0) {
				trip += arr[i].letters;
				i--;
			}
			i++;
			
			steps += 2 * location;
			int dropped = trip - arr[i].letters;
			long leftover = maxCarry - dropped;
			arr[i].letters -= leftover;
			long visits = arr[i].letters / maxCarry;
			steps += 2 * visits * arr[i].location;
			arr[i].letters -= visits * maxCarry;
			if( arr[i].letters == 0) { 
				i--;
			}
		}
		

//		while(i < houses && arr[i].location < 0) {
//			if(leftover > 0) {
//				long needed = Math.min(arr[i].letters, leftover);
//				arr[i].letters -= needed;
//				leftover -= needed;
//				if(leftover>0){
//					i++;
//				} 
//			} else {
//				if (arr[i].letters > 0) {
//					leftover = maxCarry - (arr[i].letters % maxCarry);
//					long visits = (long) Math.ceil((double)arr[i].letters / maxCarry);
//					steps -= 2 * visits * arr[i].location;	
//				}
//				i++;
//			}
//			
//		}
//		i = houses - 1;
//		leftover = 0;
//		while(i >= 0 && arr[i].location > 0) {
//			if(leftover > 0) {
//				long needed = Math.min(arr[i].letters, leftover);
//				arr[i].letters -= needed;
//				leftover -= needed;
//				if(leftover>0){
//					i--;
//				} 
//			} else {
//				if (arr[i].letters > 0) {
//					leftover = maxCarry - (arr[i].letters % maxCarry);
//					long visits = (int) Math.ceil((double)arr[i].letters / maxCarry);
//					steps += 2 * visits * arr[i].location;	
//				}
//				i--;
//			}
//			
//		}
//		
		
		System.out.println(steps);
		
	}

//	private void old() {
//		int i = 0; // house INDEX
//		long steps = 0;
//		
//		
//		while(i < houses  && arr[i].location < 0) {
//			steps -= 2 * arr[i].location ;
//			
//			
//			int capacity = maxCarry; // reset every time to restore carrying 
//			int needed = Math.min(arr[i].letters, capacity);	
//			
//			capacity -= needed; // drop it off // negative?
//			arr[i].letters -= needed;
//			if(arr[i].letters == 0) { // drop all off 
//				i++;
//				
//				while(capacity > 0 && arr[i].location < 0) { // carrying stuff keep dropping
//					int neededLeft = Math.min(arr[i].letters, capacity);	
//
//					capacity -= neededLeft; 
//					arr[i].letters -= neededLeft;
//					if(arr[i].letters == 0) { // drop all off
//						i++; // dropping
//					}
//				} // try to finish dropping off -> go to post
//			}
//		}
//		
//		i = houses - 1;
//		while(i >= 0 && arr[i].location > 0) {
//			steps += 2 * arr[i].location ;
//			
//			
//			int capacity = maxCarry; // reset every time to restore carrying 
//			int needed = Math.min(arr[i].letters, capacity);	
//			
//			capacity -= needed; // drop it off // negative?
//			arr[i].letters -= needed;
//			if(arr[i].letters == 0) { // drop all off 
//				i--;
//				
//				while(capacity > 0 && arr[i].location >= 0) { // carrying stuff keep dropping
//					int neededLeft = Math.min(arr[i].letters, capacity);	
//
//					capacity -= neededLeft; 
//					arr[i].letters -= neededLeft;
//					if(arr[i].letters == 0) { // drop all off
//						i--; // dropping
//					}
//				} // try to finish dropping off -> go to post
//			}
//		}
//	}
	
	

}
