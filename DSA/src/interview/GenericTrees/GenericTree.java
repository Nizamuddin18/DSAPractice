package interview.GenericTrees;

import java.util.*;

class Node {
	int data;
	ArrayList<Node> children;

	Node() {
		this.data = 0;
		this.children = new ArrayList<>();
	}

	Node(int data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
	/*
	 * @Override public String toString() { return "[" + data + "]"; }
	 */

}
public class GenericTree {
	
	public static void display(Node node){
		String str = "[" + node.data + "] -> ";
		for(Node child : node.children){
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			display(child);
		}
	}
	
	public static Node constructTree(int arr[]){
		Stack<Node> st = new Stack<>();
		Node root = null;
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] == -1){
				st.pop();
			}else{
				Node node = new Node(arr[i]);
				
				if(st.isEmpty()){
					root = node;		
				}else{
					st.peek().children.add(node);
				}
				st.push(node);
			}
		}
		return root;
	}
	
	public static int size(Node node){
		int size = 0;
		//calculating the size of child nodes
		for(Node child : node.children){
			int childSize = size(child);
			size += childSize;
		}
		size += 1; //size of node itself
		return size;
	}
	
	public static int getMax(Node node){
		int max = Integer.MIN_VALUE;
		for(Node child : node.children){
			max = Math.max(max, getMax(child));
		}
		max = Math.max(max, node.data);
		return max;
	}
	
	public static int getMin(Node node){
		int min = Integer.MAX_VALUE;
		for(Node child : node.children){
			min = Math.min(min, getMin(child));
		}
		min = Math.min(min, node.data);
		return min;
	}

	public static int height(Node node){
		//Height - > Edge wise i,e from Root to Depth of tree get Maximum edged Height
		int height = -1;
		for(Node child : node.children){
			height = Math.max(height, height(child));
		}
		height += 1;
		return height;
	}
	
	public static void levelOrderPrint(Node node){
		/*Algo
		Remove from Queue
		Mark 
		Visit Child
		Add to Queue*/
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node rem = queue.remove();
			System.out.print(rem.data + " ");
			for(Node child : rem.children){
				queue.add(child);
			}
		}
		System.out.println();
	}
	
	public static void levelOrderLineWise1(Node node){
		Queue<Node> mainQ = new ArrayDeque<>();
		Queue<Node> childQ = new ArrayDeque<>();
		mainQ.add(node);
		while(!mainQ.isEmpty()){
			Node rem = mainQ.remove();
			System.out.print(rem.data + " ");
			for(Node child : rem.children){
				childQ.add(child);
			}
			if(mainQ.isEmpty()){
				mainQ = childQ;
				childQ = new ArrayDeque<>();
				System.out.println();
			}
		}
	}
	
	public static void levelOrderLineWise2(Node node){
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){
			Node rem = queue.remove();
			if(rem == null){
				if(!queue.isEmpty()){
					queue.add(null);
					System.out.println();
				}
			}else{
				System.out.print(rem.data + " ");
				for(Node child : rem.children){
					queue.add(child);
				}
			}
		}
		System.out.println();
	}
	
	public static void levelOrderLineWise3(Node node){
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			int curSize = queue.size();
			for(int i = 0 ; i < curSize ; i++){
				Node rem = queue.remove();
				System.out.print(rem.data + " ");
				for(Node child : rem.children){
					queue.add(child);
				}
			}
			System.out.println();
		}
	}
	
	public static void lineWiseZigZag(Node node){
		Stack<Node> mainStack = new Stack<>();
		Stack<Node> childStack = new Stack<>();
		int level = 1;
		mainStack.push(node);
		while(!mainStack.isEmpty()){
			Node rem = mainStack.pop();
			System.out.print(rem.data + " ");
			if(level % 2 == 1){
				//Move Left to Right i.e its Child will be printed right to Left
				for(int i = 0 ; i < rem.children.size() ; i++){
					Node child = rem.children.get(i);
					childStack.push(child);
				}
			}else{
				//Move Right to Left i.e its Child will be printed left to Right
				for(int i = rem.children.size() - 1 ; i >= 0  ; i--){
					Node child = rem.children.get(i);
					childStack.push(child);
				}
			}
			
			if(mainStack.isEmpty()){
				mainStack = childStack;
				childStack = new Stack<>();
				System.out.println();
				level++;
			}
		}
	}

	
	public static ArrayList<Integer> nodeToRootPath(Node node , int target){
		if(node.data == target) {
			ArrayList<Integer> bres = new ArrayList<>();
			bres.add(node.data);
			return bres;
		}
		
		for(Node child : node.children){
			ArrayList<Integer> pathChild = nodeToRootPath(child , target);
			if(pathChild.size() > 0){
				pathChild.add(node.data);
				return pathChild;
			}
		}
		return new ArrayList<>();
	}
	
	public static int LCA(Node node , int data1 , int data2){
		ArrayList<Integer> path1 = nodeToRootPath(node , data1);
		ArrayList<Integer> path2 = nodeToRootPath(node , data2);
		int i = path1.size()-1;
		int j = path2.size()-1;
		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)){
			i--;
			j--;
		}
		i++;
		j++;
		return path1.get(i);
	}
	
	public static int distance(Node node, int data1 , int data2){
		ArrayList<Integer> path1 = nodeToRootPath(node , data1);
		ArrayList<Integer> path2 = nodeToRootPath(node , data2);
		int i = path1.size()-1;
		int j = path2.size()-1;
		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)){
			i--;
			j--;
		}
		i++;
		j++;
		return i + j;
	}
	
	public static void removeLeaves(Node node){
		for(int i = node.children.size() - 1 ; i >= 0 ; i--){
			Node child = node.children.get(i);
			if(child.children.size() == 0)
				node.children.remove(child);
		}
		for(Node child : node.children)
			removeLeaves(child);
	}
	
	public static void mirror(Node node){
		for(Node child : node.children)
			mirror(child);
		Collections.reverse(node.children);
	}
	
	public static boolean areSimilar(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size())
			return false;
		boolean res = true;
		int size = node1.children.size();
		for (int i = 0; i < size; i++) {
			Node child1 = node1.children.get(i);
			Node child2 = node2.children.get(i);
			res = areSimilar(child1, child2);
			if (res == false)
				return false;
		}
		
		return res;
	}

	public static boolean areMirror(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size())
			return false;

		int size = node1.children.size();
		boolean res = true;
		for (int i = 0; i < size; i++) {
			Node child1 = node1.children.get(i);
			Node child2 = node2.children.get(size - i - 1);
			res = areMirror(child1, child2);
			if (res == false)
				return false;
		}
		
		return res;
	}
	
	static Node predecessor;
	static Node successor;
	static int state;
	public static void predecessorAndSuccessor(Node node , int target){
		if(state == 0){
			if(node.data == target){
				state = 1;
			}else{
				predecessor = node;
			}
		}else if(state == 1){
			successor = node;
			state++;
		}
		
		for(Node child : node.children)
			predecessorAndSuccessor(child , target);

	}
	
	static int ceil; // smallest among larger values
	static int floor; //largest among smaller values
	public static void ceilAndFloor(Node node , int target){
		if(node.data > target){
			if(node.data < ceil)
				ceil = node.data;
		}
		
		if(node.data < target){
			if(node.data > floor){
				floor = node.data;
			}
		}
		
		for(Node child : node.children)
			ceilAndFloor(child , target);
	}
	
	public static int kthLargest(Node node , int k){
		floor = Integer.MIN_VALUE;
		int factor = Integer.MAX_VALUE;
		for(int i = 0 ; i < k ; i++){
			ceilAndFloor(node , factor);
			factor = floor;
			floor = Integer.MIN_VALUE;
		}
		return factor;
	}
	
	static int maxSum = Integer.MIN_VALUE;
	static int maxSumNode = 0;
	public static int maxSubtreeSum(Node node){
		int sum = 0;
		for(Node child : node.children){
			int csum = maxSubtreeSum(child);
			sum += csum;
		}
		sum += node.data;
		if(sum > maxSum){
			maxSum = sum;
			maxSumNode = node.data;
		}
		return sum;
	}
	
	static int diameter = 0;
	public static int diameter(Node node){
		int deepestHeight = -1;
		int secondDeepestHeight = -1;
		for(Node child : node.children){
			int childheight = diameter(child);
			if(childheight > deepestHeight){
				secondDeepestHeight = deepestHeight;
				deepestHeight = childheight;	
			}else if(childheight > secondDeepestHeight){
				secondDeepestHeight = childheight;
			}
		}
		
		int potentialDiameter = deepestHeight + secondDeepestHeight + 2;
		if(diameter < potentialDiameter)
			diameter = potentialDiameter;
		
		deepestHeight += 1;
		return deepestHeight;
	}
	
	public static boolean find(Node node, int data) {
	    if(node.data == data) return true;
	    boolean flag = false;
	    
	    for(Node child : node.children){
	    	flag = find(child , data);
	    	if(flag)
	    		return true;
	    }
	    return flag;
	  }
	
	static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void IterativePreandPostOrder(Node node) {
		Stack<Pair> st = new Stack<>();
		String pre = "";
		String post = "";
		Pair rootpair = new Pair(node, -1);
		st.push(rootpair);

		while (!st.isEmpty()) {
			Pair top = st.peek();
			if (top.state == -1) {
				pre += top.node.data + " ";
				top.state++;
			} else if (top.state == top.node.children.size()) {
				post += top.node.data + " ";
				st.pop();
			} else {
				Pair childpair = new Pair(top.node.children.get(top.state), -1);
				st.push(childpair);
				top.state++;
			}
		}
		System.out.println(pre);
		System.out.println(post);
	}
	
	public static boolean isSymmetry(Node node1 , Node node2){
		return areMirror(node1 , node2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1,
                -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Node root = constructTree(arr);
		System.out.println("1.Display Generic Tree : ");
		System.out.println("2.Size of Generic Tree : ");
		System.out.println("3.Max in Generic Tree : ");
		System.out.println("4.Min in Generic Tree : ");
		System.out.println("5.Height of Generic Tree : ");
		System.out.println("6.Level Order Traversal : ");
		System.out.println("7.Level Order LineWise1 : ");
		System.out.println("8.Level Order LineWise2 : ");
		System.out.println("9.Level Order LineWise3 : ");
		System.out.println("10.LineWise ZigZag : ");
		System.out.println("11.Node to Root Path : ");
		System.out.println("12.Lowest Common Ancestor : ");
		System.out.println("13.Distance Between Two Nodes : ");
		System.out.println("14.Remove Leaves : ");
		System.out.println("15.Mirror of Generic Tree : ");
		System.out.println("16.Predecessor and Successor : ");
		System.out.println("17.Ceil and Floor : ");
		System.out.println("18.Kth Largest Element : ");
		System.out.println("19.Maximum Subtree Sum : ");
		System.out.println("20.Diameter of Generic Tree : ");
		System.out.println("21.Find in Generic Tree : ");
		System.out.println("22.Are Generic Tree Similar : ");
		System.out.println("23.Are Generic Tree Mirror : ");
		System.out.println("24.Iterative Traversal : ");
		while(true){
			System.out.println("Enter Choice(Press -1 to exit) : ");
			int choice = sc.nextInt();
			switch(choice){
			case 1 : 
				display(root);
				break;
			case 2 : 
				int size = size(root);
				System.out.println("Size of Generic Tree : " + size);
				break;
			case 3 : 
				int max = getMax(root);
				System.out.println("Max Node fo Generic Tree : " + max);
				break;
			case 4 : 
				int min = getMin(root);
				System.out.println("Min Node fo Generic Tree : " + min);
				break;
			case 5 : 
				int height = height(root);
				System.out.println("Height of Generic Tree : " + height);
				break;
			case 6 : 
				levelOrderPrint(root);
				break;
			case 7 : 
				levelOrderLineWise1(root);
				break;
			case 8 :
				levelOrderLineWise2(root);
				break;
			case 9 : 
				levelOrderLineWise3(root);
				break;
			case 10 :
				lineWiseZigZag(root);
				break;
			case 11:	
				int target = 120;
				ArrayList<Integer> path  = nodeToRootPath(root , target);
				System.out.println("Node to Root Path : " + path);
				break;
			case 12 : 
				int data1 = 70;
				int data2 = 120;
				int lca = LCA(root, data1 , data2);
				System.out.println("Lowest Common Ancestor : " + lca);
				break;
			case 13 : 
				int d1 = 70;
				int d2 = 120;
				int distance = distance(root ,d1 ,d2);
				System.out.println("Distance between " + d1 + " and " + d2 + " : " + distance);
				break;
			case 14 : 
				System.out.println("Before Removal : ");
				display(root);
				removeLeaves(root);
				System.out.println("After Removal  : ");
				display(root);
				break;
			case 15 : 
				System.out.println("Original Tree : ");
				display(root);
				mirror(root);
				System.out.println("Mirror Tree : ");
				display(root);
				break;
			case 16 : 
				predecessorAndSuccessor(root , 120);
				System.out.println("Predecessor : " + predecessor.data);
				System.out.println("Successor : " + successor.data);
				break;
			case 17 : 
				int no = 90;
				ceil = Integer.MAX_VALUE;
				floor = Integer.MIN_VALUE;
				ceilAndFloor(root , no);
				if(ceil == Integer.MAX_VALUE)
					System.out.println("No Ceil exist");
				else
					System.out.println("Ceil of " + no  + " is : " + ceil);
				
				if(floor == Integer.MIN_VALUE)
					System.out.println("No Floor exist");
				else
					System.out.println("Floor of " + no  + " is : " + floor);		
				break;
			case 18 : 
				int kthlargest = kthLargest(root , 3);
				System.out.println("Kth Largest Element : " + kthlargest);
				break;
			case 19 : 
				maxSubtreeSum(root);
				System.out.println("Maximum Subtree Sum : " + maxSum + " @ Node : " + maxSumNode);
				break;
			case 20 : 
				diameter(root);
				System.out.println("Diameter of Generic Tree : " + diameter);
				break;
			case 21 : 
				boolean flag = find(root , 130);
				System.out.println("Node was found : " + flag);
				break;
			case 22 : 
				Node root1 = constructTree(arr);
				boolean areSame = areSimilar(root , root1);
				System.out.println("Are Generic Trees Similar : " + areSame);
				break;
			case 23 : 
				Node root2 = constructTree(arr);
				mirror(root2);
				boolean areMirror = areMirror(root , root2);
				System.out.println("Are Generic Trees Mirror : " + areMirror);
				break;
			case 24 : 
				IterativePreandPostOrder(root);
				break;
			default : 
				System.out.println("...Quit...");
				System.exit(0);
			}		
		}
	}
}
