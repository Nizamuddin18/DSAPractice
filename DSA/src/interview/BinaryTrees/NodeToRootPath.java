package interview.BinaryTrees;

import java.util.ArrayList;
public class NodeToRootPath {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		NodeToRootPath ntrp = new NodeToRootPath();
		Node root = tree.constructBinaryTree();
		int data = 70;
		ArrayList<Node> path = ntrp.findNodeToRootPath(root , data);
		System.out.println("Path : " + path);
		test();
	}
	
	public ArrayList<Node> findNodeToRootPath(Node node , int data){
		//Initially root is passed
		ArrayList<Node> res = new ArrayList<>(); 
		if(node == null)
			return res;
		if(node.val == data){
			res.add(node);//the given node matches thus this path will be added
			return res;
		}
		ArrayList<Node> lres = findNodeToRootPath(node.left , data);
		if(lres.size() > 0){
			lres.add(node);
			return lres;
		}
		ArrayList<Node> rres = findNodeToRootPath(node.right , data);
		if(rres.size() > 0){
			rres.add(node);
			return rres;
		}
		return res;
	}
	static void test(){
		StringBuilder builder = new StringBuilder();
		builder.append("1->");
		builder.append("2");
		String str = builder.toString();
		System.out.println(str);
	}

}
