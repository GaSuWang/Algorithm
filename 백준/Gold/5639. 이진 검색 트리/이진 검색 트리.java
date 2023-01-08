
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node{
		int num;
		Node right;
		Node left;
		Node(int num){
			this.num = num;
			this.right=null;
			this.left=null;
		}
		
	}
	public static void setTree(Node pNode,int num) {
		if(num>pNode.num) {
			//오른쪽
			if(pNode.right==null) {
				pNode.right=new Node(num);
			}
			else {
				setTree(pNode.right,num);
			}
		}
		else {
			//왼쪽 
			if(pNode.left==null) {
				pNode.left = new Node(num);
			}
			else {
				setTree(pNode.left,num);
			}
		}
	}
	
	public static void postSearch(Node pNode) {
		if(pNode.left!=null) {
			postSearch(pNode.left);
		}
		if(pNode.right!=null) {
			postSearch(pNode.right);
		}
		System.out.println(pNode.num);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		Node root = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			temp = br.readLine();
			if(temp == null || temp.equals("")) break;
			int insertNum = Integer.parseInt(temp);
			setTree(root,insertNum);
		}
		postSearch(root);
		
		
	}
}