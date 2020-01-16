package com.esh.tree;

public class BinarySearchTree extends BinaryTree {
	BNode root;

	/**
	 * Search for parent node such that element value
	 * 
	 */
	public void insertNode(int element) {
		BNode node = new BNode(element);
		if (null == root) {
			root = node;
			return;
		}
		BNode parentNode = searchParentNode(root, element);
		if (element < parentNode.elem) {
			parentNode.left = node;
		} else {
			parentNode.right = node;
		}
	}

	public BNode searchParentNode(BNode root, int element) {
		if (element < root.elem && root.left != null && root.left.elem != element) {
			return searchParentNode(root.left, element);
		}
		if (element > root.elem && root.right != null && root.right.elem != element) {
			return searchParentNode(root.right, element);
		}
		return root;
	}

	public BNode searchNode(BNode node, int element) {
		if (null == node) {
			return null;
		}
		if (element == node.elem) {
			return node;
		} else if (element < node.elem) {
			return searchNode(node.left, element);
		} else {
			return searchNode(node.right, element);
		}
	}

	public void deleteNode(int element) {
		BNode parentNode = searchParentNode(root, element);
		BNode elemNode = (parentNode.left != null && parentNode.left.elem == element) ? parentNode.left
				: parentNode.right;
		boolean isLeftNode = (parentNode.left != null && parentNode.left.elem == element);
		if (null == elemNode.left && null == elemNode.right) { //No child
			if(isLeftNode){
				parentNode.left = null;
			}else{
				parentNode.right = null;
			}	
		}else if( null == elemNode.left  && elemNode.right != null){ // Single child 
			if(isLeftNode){
				parentNode.left = elemNode.right;
			}else{
				parentNode.right = elemNode.right;
			}	
		}else if(null == elemNode.right && elemNode.left != null){ //Single child
			if(isLeftNode){
				parentNode.left = elemNode.left;
			}else{
				parentNode.right = elemNode.left;
			}	
		}else{ // 2 child
			BNode successorParent = leftMostNodeParent(elemNode.right);
			int successorVal = successorParent.left.elem;
			elemNode.elem = successorVal;
			successorParent.left = null;
		}

	}
	
	public BNode leftMostNodeParent(BNode node){
		while(node.left != null && node.left.left != null){
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertNode(2);
		tree.insertNode(8);
		tree.insertNode(1);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.insertNode(6);
		tree.insertNode(5);
		tree.inOrderTraversal(tree.root);
		System.out.println("\nSearch 4: " + (tree.searchNode(tree.root, 4) != null));
		System.out.println("\nSearch 0: " + (tree.searchNode(tree.root, 0) != null));
		tree.deleteNode(3);
		tree.deleteNode(4);
		tree.deleteNode(8);
		tree.inOrderTraversal(tree.root);
	}
}
