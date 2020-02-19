package com.esh.trie;

import java.util.ArrayList;
import java.util.List;

class Node {
	Node[] children = new Node[26];
	boolean isLastNode;
	
	boolean isEmpty(){
		boolean isEmpty = false;
		for(Node child: children){
			if(null == child){
				isEmpty = true;
				break;
			}
		}
		return isEmpty;
	}
}

public class TestTrie {
	Node root = new Node();

	public void insert(String key) {
		char[] keyChars = key.toCharArray();
		Node currentNode = root;
		for (char ch : keyChars) {
			int charVal = ch - 'a';
			if (null == currentNode.children[charVal]) {
				currentNode.children[charVal] = new Node();
			}
			currentNode = currentNode.children[charVal];
		}
		currentNode.isLastNode = true;
	}

	public boolean search(String key) {
		char[] keyChars = key.toCharArray();
		Node currentNode = root;
		for (char ch : keyChars) {
			int charVal = ch - 'a';
			if (null == currentNode.children[charVal]) {
				return false;
			}
			currentNode = currentNode.children[charVal];
		}
		return currentNode.isLastNode;
	}

	/*
	 * During delete operation we delete the key in bottom up manner using
	 * recursion. The following are possible conditions when deleting key from
	 * trie,
	 * 
	 * - Key may not be there in trie. Delete operation should not modify trie.
	 * - Key present as unique key (no part of key contains another key (prefix),
	 * nor the key itself is prefix of another key in trie). Delete all the
	 * nodes. 
	 * - Key is prefix key of another long key in trie. Unmark the leaf
	 * node. 
	 * - Key present in trie, having atleast one other key as prefix key.
	 * Delete nodes from end of key until first leaf node of longest prefix key.
	 */
	
	public Node remove(Node root, String key, int depth) throws Exception{
		//Node is empty
		if(root.children.length == 0){
			return null;
		}
		
		//If this is the last node being recursed
		if(key.length() == depth){
			//If last node, mark it as false
			if(root.isLastNode){
				root.isLastNode = false;
				root = null;
			}
			//If root is empty, means it is not prefix of another string
			else if(root.isEmpty()){
				root=null;
			}
			
			return root;
		}
		
		//If not last node recursively delete child node
		int currentChar = key.toCharArray()[depth] - 'a';
		root.children[currentChar] = remove(root.children[currentChar], key, depth+1);
		
		// If root does not have any child (its only child got  
	    // deleted), and it is not end of another word. 
	    if (root.isEmpty() && root.isLastNode == false) { 
	        root = null; 
	    } 
		return root;
	}
	
	public String longestPrefixMatch(String key){
		Node currentNode = root;
		String prefix = "";
		StringBuilder longestPrefix = new StringBuilder();
		char[] keyChars = key.toCharArray();
		for(char ch : keyChars){
			int charIndex = ch -'a';
			if(currentNode.children[charIndex] != null){
				longestPrefix.append(ch + "");
				if(currentNode.children[charIndex].isLastNode){
					prefix = longestPrefix.toString();
				}
				currentNode = currentNode.children[charIndex];
			}else{
				break;
			}
		}
		return prefix;
	}
	

	public static void main(String[] args) throws Exception {
		TestTrie trie = new TestTrie();
		String[] strs = {"are", "area", "base", "cat", "cater", "children", "basement"};
		for(String str : strs){
			trie.insert(str);
		}
		trie.insert("abc");
		trie.insert("abcde");
		trie.insert("def");
		//trie.remove(trie.root, "abc", 0);
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("defg"));
		System.out.println(trie.longestPrefixMatch("caterer"));
		System.out.println(trie.longestPrefixMatch("basemexy"));
	//	System.out.println(trie.longestPrefixMatch("child"));
	}

}
