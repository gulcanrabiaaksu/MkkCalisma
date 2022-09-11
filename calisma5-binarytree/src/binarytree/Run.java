package binarytree;
/*
 * preorder kok,sol,sag
 * inorder sol,kok,sag
 * postorer sol,sag,kok
 */

public class Run {

	public static void main(String[] args) {
		BinTree bst=new BinTree();
		
		bst.add(27);
		bst.add(14);
		bst.add(35);
		bst.add(10);
		bst.add(19);
		bst.add(31);
		bst.add(42);
		bst.add(45);
		bst.add(49);
		bst.add(25);
		
		System.out.println("***PREORDER***");
		bst.printPreOrder();
		System.out.println("***INORDER***");
		bst.printInOrder();
		System.out.println("***POSTORDER***");
		bst.printPostOrder();
		
		bst.printSize();
		bst.printHeight();
		
		
		bst.search(35);
		bst.search(45);
		bst.printBalance();

	}

}
