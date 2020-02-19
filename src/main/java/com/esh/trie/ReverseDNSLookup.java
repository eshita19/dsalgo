package com.esh.trie;

class DNSLookupNode{
	DNSLookupNode[] children = new DNSLookupNode[11]; // 0-9 and "."
	String url;
}
public class ReverseDNSLookup {
	DNSLookupNode root = new DNSLookupNode();
	
	public void insert(String ip, String url) {
		char[] keyChars = ip.toCharArray();
		DNSLookupNode currentNode = root;
		for (char ch : keyChars) {
			int charVal = (ch == '.') ? 10: ch -'0';
			if (null == currentNode.children[charVal]) {
				currentNode.children[charVal] = new DNSLookupNode();
			}
			currentNode = currentNode.children[charVal];
		}
		currentNode.url = url;
	}
	
	
	public String search(String ip) {
		char[] ipChars = ip.toCharArray();
		DNSLookupNode currentNode = root;
		for (char ch : ipChars) {
			int charVal = (ch == '.') ? 10: ch -'0';
			if (null == currentNode.children[charVal]) {
				return null;
			}
			currentNode = currentNode.children[charVal];
		}
		return currentNode.url;
	}
	
	public static void main(String[] args) {
		ReverseDNSLookup dnslookup = new ReverseDNSLookup();
		dnslookup.insert("10.12.123.23", "google.com");
		System.out.println(dnslookup.search("10.12.123.23"));
	}
}
