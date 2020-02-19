package com.esh.trie;

import java.util.ArrayList;
import java.util.List;

class MatrixNode{
	MatrixNode[] children = new MatrixNode[2];
	boolean isLastNode;
}
public class MatrixUniqueRow {
	MatrixNode root = new MatrixNode();
	
	public boolean insert(String key) {
		boolean isKeyAlreadyPresent = false;
		char[] keyChars = key.toCharArray();
		MatrixNode currentNode = root;
		for (char ch : keyChars) {
			int charVal = ch - '0';
			if (null == currentNode.children[charVal]) {
				currentNode.children[charVal] = new MatrixNode();
				currentNode = currentNode.children[charVal];
			}else{
				isKeyAlreadyPresent = true;
			}
		}
		currentNode.isLastNode = true;
		return isKeyAlreadyPresent;
	}
	
	public static void main(String[] args) {
		MatrixUniqueRow mRow = new MatrixUniqueRow();
		String[] matrixElems = {"0101","0101", "0010", "1010"};
		List<String> uniqueElems = new ArrayList<>();
		for(String matrixElem: matrixElems){
			if(mRow.insert(matrixElem)){
				uniqueElems.add(matrixElem);
			}
		}
		
		for(String elem: uniqueElems){
			System.out.println(elem);
		}
	}
}
