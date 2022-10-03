package binarytree;

class Node {

	
	int value;
	Node right;
	Node left;
	
	public Node(int val) {
		this.value=val;
		right=null;
		left=null;
	}
	public void add(int val) {
		if(val<value) {
			if(left == null) {
				left= new Node(val);
			}
			else {
			left.add(val);;
			}
		}
		else {
			if(right== null) {
				right=new Node(val);
			}
			else {
				right.add(val);
			}
		}
	}
	public void printPreOrder() {
		System.out.println(this.value);
		if(left!=null) { //left null degilse null olana kadar cagirir
			left.printPreOrder();
		}
		if(right!=null) {//right null degilse null olana kadar cagirir
			right.printPreOrder();
			}
		}
	

	public void printInOrder() {
		if(left!=null) {
			left.printInOrder();
		}
		System.out.println(this.value);
		if(right!=null) {
			right.printInOrder();
					
			}
		}
	
	public void printPostOrder() {
		if(left!=null) {
			left.printInOrder();
		}
		if(right!=null) {
			right.printPostOrder();
			}
		System.out.println(this.value);
		}
	
	

}


	public class BinTree{
		Node root=null; //kok root olusturduk null verdik
		
		public void add(int val) {
			if (root==null) { //kok yoksa
				root= new Node(val); //kok olustur
			}else {
			root.add(val);
			}	
		}
	
	public void printPreOrder() {
		if(root!=null) {
			root.printPreOrder();
			}
		}
	
	public void printInOrder() {
		if(root!=null) {
			root.printInOrder();
			}
		}
	
	public void printPostOrder() {
		if(root!=null) {
			root.printPostOrder();
			}
		}
	
	public int getSize(Node root) {
		if(root==null) {
			return 0;
		}
		return getSize (root.left) + getSize(root.right) + 1 ;
	}
	
	
	public void printSize() {
	
		System.out.println("Size of the three:" + this.getSize(root));
	}
	public int getHeight(Node root) {
		if(root==null) {
			return 0;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right) + 1);
	}
	
	public void printHeight() {
		
		System.out.println("Height of the tree:" + this.getHeight(root));
	}
	
	public boolean contains(Node root, int val) {
		if(root!=null) {
			if(root.value==val) {
				return true;
			}else {
				return contains(root.left,val) || contains(root.right,val);
			}
		}
		return false;
	}
	
	public void search(int value) {
		System.out.println("Deger true ise " + value  +" vardýr. Deger: " + this.contains(root,value));
	}
	
	
	public boolean isBalanced (Node root) {  
		if(root==null) {
			return true;
		}
		int heightDif= getHeight(root.left) + getHeight(root.right);
		
		if(Math.abs(heightDif)>1) {
			return false;
		}
		else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	public void printBalance() {
		System.out.println("Bu agac dengeye sahip mi:" + this.isBalanced(root));
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	