/**
 * 
 */
package trees;

import java.util.Stack;

/**
 * @author mandar
 *
 */
public class BinarySearchTree {

	static Node root;
	public BinarySearchTree(){
		BinarySearchTree.root=null;
	}

	
	class Node{
		private int data;
		private Node leftNode;
		private Node rightNode;
		
		public Node(int data){
			this.data=data;
			this.leftNode=null;
			this.rightNode=null;			
		}
	}
	
	public void addNode(int data){
		Node node=new Node(data);
		if(root==null){
			root=node;
			return;
		}else{
			Node current=root;
			Node parent=null;
			while(true){
				parent=current;
				if(data>parent.data){
					current=current.rightNode;
					if(current==null){
						parent.rightNode=node;
						return;
					}
				}else if(data<parent.data){
					current=current.leftNode;
					if(current==null){
						parent.leftNode=node;
						return;
					}
				}else{
					System.out.println("Node already present in the tree.");
					break;
				}
			}
		}
	}
	
	public void inorderRecursion(Node root){
		if(root!=null){
			inorderRecursion(root.leftNode);
			System.out.print(" " + root.data);
			inorderRecursion(root.rightNode);
		}
	}
	
	public void preorderRecursion(Node node){
		if(node!=null){
			System.out.print(" " + node.data);
			preorderRecursion(node.leftNode);			
			preorderRecursion(node.rightNode);
		}
	}

	public void postorderRecursive(Node root){
		if(root!=null){
			postorderRecursive(root.leftNode);			
			postorderRecursive(root.rightNode);
			System.out.print(" " + root.data);
		}
	}
	
	public void preorderIterative( Node root) {
	    if( root == null ) return;

	    Stack<Node> stack = new Stack<Node>( );
	    stack.push( root );

	    while( ! stack.isEmpty( ) ) {
	        Node current = stack.pop( );
	        if( current.rightNode != null ) stack.push( current.rightNode );
	        if( current.leftNode != null ) stack.push( current.leftNode );
	        System.out.print( current.data + " " );
	    }
	}
	
	public void inorderIterative(Node root){
		Stack<Node> stack = new Stack<Node>( );
		Node node=root;

		while(node!=null || !stack.isEmpty()){
			if(node!=null){
				stack.push(node);
				node=node.leftNode;
			}else{
				node=stack.pop();
				System.out.print(" "+node.data);
				node=node.rightNode;
			}
		}
	}
	
	public void postorderIterative(Node root){

		Stack<Node> stack1 = new Stack<Node>( );
		Stack<Node> stack2 = new Stack<Node>( );
		
		stack1.push(root);
		while(!stack1.empty()){
			Node node=stack1.pop();
			stack2.push(node);			
				
			if(node.leftNode!=null){	
				stack1.push(node.leftNode);
			}
			if(node.rightNode!=null){
				stack1.push(node.rightNode);
			}
		}	
		String str="";
		
		while(!stack2.empty()){
			Node nodeStack=stack2.pop();
			str=" "+nodeStack.data;
			System.out.print(str);
		}
		System.out.println();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();		
		bst.addNode(10);
		bst.addNode(5);
		bst.addNode(40);
		bst.addNode(1);
		bst.addNode(7);
		bst.addNode(20);
		bst.addNode(50);
		
		
		System.out.println("Recursive Post Order");
		bst.postorderRecursive(root);
		System.out.println();
		System.out.println("Iterative Post Order");
		bst.postorderIterative(root);

		System.out.println("Recursive In Order");
		bst.inorderRecursion(root);
		System.out.println();
		System.out.println("Iterative In Order");
		bst.inorderIterative(root);
		
		System.out.println();
		System.out.println("Recursive Pre Order");		
		bst.preorderRecursion(root);
		System.out.println();
		System.out.println("Iterative Pre Order");
		bst.preorderIterative(root);

	}	
}
