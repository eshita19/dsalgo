
package com.esh.tree;

import java.util.LinkedList;
import java.util.Queue;

class BNode {
	int elem;
	BNode left;
	BNode right;

	BNode(int elem) {
		this.elem = elem;
	}
}

public class BinaryTree {
	BNode root;

	/**
	 * If root is null, root = element. Else do a level order traversal: find
	 * the last level with child to be inserted.
	 * 
	 * @param element
	 */
	public void insertNode(int element) {
		if (null == root) {
			root = new BNode(element);
		} else {
			// Level order traversal
			Queue<BNode> queue = new LinkedList<BNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BNode node = queue.poll();
				if (null == node.left) {
					node.left = new BNode(element);
					break;
				}
				if (null == node.right) {
					node.right = new BNode(element);
					break;
				}
				queue.add(node.left);
				queue.add(node.right);
			}

		}
	}
	
	public void levelOrderTraversal(){
		if(null == root){
			throw new IllegalStateException("Cannot traverse empty tree");
		}
		
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BNode node = queue.poll();
			System.out.print(node.elem + ",");
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
		System.out.println();
	}
	
	public BNode getElement(int element){
		BNode searchedElem = null;
		if(null == root){
			throw new IllegalStateException("Tree is empty");
		}
		//Level order traversal
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BNode node = queue.poll();
			if(node.elem == element){
				searchedElem = node;
				break;
			}
			if(node.left != null){
				queue.add(node.left);
			}
			
			if(node.right != null){
				queue.add(node.right);
			}
		}
		return searchedElem;
	}
	
	public void deleteNode(int element){
		if(null == root){
			throw new IllegalStateException("Tree is empty");
		}
		
		
	    BNode nodeToBeDeleted = getElement(element);
	    
		//Find the deepest node
		BNode node = null;
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			node = queue.poll();
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
		nodeToBeDeleted.elem = node.elem;
		node = null;
	}
	
	
	//root, left subtreee, right subtree
	public void preOrderTraversal(BNode node){
		if(null == node){
			return;
		}
		System.out.print(node.elem + ", ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	//left subtree, right subtree, root
	public void postOrderTraversal(BNode node){
		if(null == node){
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.elem + ", ");
	}
	
	//Left subtree, root, right subtree
	public void inOrderTraversal(BNode node){
		if(null == node){
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.elem + ", ");
		inOrderTraversal(node.right);
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertNode(1);
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.levelOrderTraversal();
		System.out.println("Is 6 present? " + tree.getElement(6) != null);
		System.out.println("Is 3 present? " + tree.getElement(3) != null);
		tree.preOrderTraversal(tree.root);
		System.out.println();
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
		tree.deleteNode(2);
		System.out.println();
		tree.levelOrderTraversal();
	}

}
