package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Trie {

	private Node root;

	public Trie(){
		root=new Node();
	}
	
	public void insert(String word) {
		Map<Character, Node> children = root.children;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			
			Node node;
			if(children.containsKey(c)){
				node=children.get(c);
			}else{
				node=new Node(c);
				children.put(c, node);
			}
			children=node.children;
			
			if(i==word.length()-1){
				node.isLeaf=true;
			}
		}
	}

	public boolean search(String word) {
		Map<Character, Node> children = root.children;
		for(int i=0;i<word.length();i++){
			char c=word.charAt(i);
			if(!children.containsKey(c)){
				return false;
			}
			Node node = children.get(c);
			children=node.children;
			if(i==word.length()-1){
				return node.isLeaf;
			}
		}
		
		return true;
	}

	public List<String> autoComplete(String word) {
		if(root==null||word==null||word.isEmpty()){
			return null;
		}
		Node node=getNode(word);
		if(node==null){
			return null;
		}
		List<String> leaves=findAllLeaves(node,new StringBuilder());
		for(int i=0;i<leaves.size();i++){
			leaves.set(i, word+leaves.get(i));
		}
		return leaves;
	}

	private List<String> findAllLeaves(Node node, StringBuilder sb) {
		List<String> leafStrings=new ArrayList<String>();
		for( Entry<Character, Node> entry:node.children.entrySet()){
			StringBuilder sbNode=new StringBuilder(sb.toString());
			Node child = entry.getValue();
			if(child.isLeaf){
				leafStrings.add(sbNode.toString()+child.key);
			}
			sbNode.append(child.key);
			leafStrings.addAll(findAllLeaves(child,sbNode));
		}
		return leafStrings;
	}

	private Node getNode(String word) {
		Node currNode = root;
		for(int i=0;i<word.length();i++){
			char c=word.charAt(i);
			if(!currNode.children.containsKey(c)){
				return null;
			}
			currNode=currNode.children.get(c);
		}
		return currNode;
	}

}

class Node {

	char key;
	Map<Character, Node> children=new HashMap<Character, Node>();
	boolean isLeaf;

	public Node() {
	}
	
	public Node(char c){
		this.key=c;
	}

}