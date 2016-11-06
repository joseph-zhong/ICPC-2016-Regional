import java.util.ArrayList;
import java.util.Scanner;

public class ProbH {
	 // PAINT
	private static class Node {
		long path = 0;
		ArrayList<Node> children = new ArrayList<>();
		
		long min;
		long max;
		
		public Node(long min, long max) {
			this.min = min;
			this.max = max;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		long sections = scn.nextLong();
		int artists = scn.nextInt();

		long[][] indices = new long[artists][2]; 
		for (int i = 0; i < artists; i++) {
			indices[i][0] = scn.nextLong();
			indices[i][1] = scn.nextLong();
		}
		
		Node[] nodeArr = new Node[artists];
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = new Node(indices[i][0], indices[i][1]);
		}
		
		for(int i = 0; i < nodeArr.length; i++ ){
			for(int j = i + 1; j < nodeArr.length; j++ ){
				if (nodeArr[j].min > nodeArr[i].max) {
					nodeArr[i].children.add(nodeArr[j]); 
				}
			}
		}

		for (int i = 0; i < nodeArr.length; i++) {
			findPath(nodeArr[i]);
		}
		
		long max = 0;
		for (int i = 0; i < nodeArr.length; i++) {
			max = Math.max(max, nodeArr[i].path);
			
		}
		
		
		
		System.out.println(sections - max);
		
	}

	private static void findPath(Node n) {
		if (n.path > 0) {
			return;
		}
		if (n.children.isEmpty()) {
			n.path = n.max - n.min + 1;
		}
		else {
			long max = 0;
			
			for(Node child : n.children) {
				if (child.path == 0) {
					findPath(child);
				}
				
				max = Math.max(max, child.path);
			}
			n.path = n.max - n.min + 1 + max;
		}
	}

}
