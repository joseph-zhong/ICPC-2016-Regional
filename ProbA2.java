import java.util.ArrayList;
import java.util.Scanner;

public class ProbA2 {

	private static class Node {
		int index;
		char c;
		int path = 0;
		ArrayList<Node> children = new ArrayList<>();
		
		public Node(int index, char c) {
			this.c = c;
			this.index = index;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
				
		
		Node[] nodeArr = new Node[str.length()];
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = new Node(i, str.charAt(i));
		}
		
		for(int i = 0; i < nodeArr.length; i++ ){
			for(int j = i + 1; j < nodeArr.length; j++ ){
				if (nodeArr[j].c > nodeArr[i].c) {
					nodeArr[i].children.add(nodeArr[j]); 
				}
			}
		}

		
		for (int i = 0; i < nodeArr.length; i++) {
			findPath(nodeArr[i]);
		}
		int max = 0;
		for (int i = 0; i < nodeArr.length; i++) {
			max = Math.max(max, nodeArr[i].path);
		}
		
		
		System.out.println(26 - max);

	}
	
	private static void findPath(Node n) {
		if (n.path > 0) {
			return;
		}
		if (n.children.isEmpty()) {
			n.path = 1;
		}
		else {
			int max = 0;
			
			for(Node child : n.children) {
				if (child.path == 0) {
					findPath(child);
				}
				
				max = Math.max(max, child.path);
			}
			n.path = max + 1;
		}
	}

}
