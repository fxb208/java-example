package com.margo.project.tree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTreeTest test=new BinarySearchTreeTest();
		BinarySearchTree binarySearchTree=test.initBinarySearchTree();
		test.getRoot(binarySearchTree);
	}
	
	public void getRoot(BinarySearchTree binarySearchTree) {
		System.out.println(binarySearchTree.getRoot().value);
	}
	
	public void inorderTreeWalk(BinarySearchTree binarySearchTree) {
		List<Integer> lst=new LinkedList<Integer>();
		binarySearchTree.inorderTreeWalk(lst, binarySearchTree.getRoot());
		for(int i=0;i<lst.size();i++) {
			System.out.println(lst.get(i));
		}
	}
	
	
	public void treeMaximum(BinarySearchTree binarySearchTree) {
		System.out.println("Maximum:"+binarySearchTree.treeMaximum(binarySearchTree.getRoot()).value);
	}
	
	public BinarySearchTree initBinarySearchTree() {
		BinarySearchTree binarySearchTree=new BinarySearchTree();
		binarySearchTree.treeInsert(60);
		binarySearchTree.treeInsert(12);
		binarySearchTree.treeInsert(10);
		binarySearchTree.treeInsert(13);
		binarySearchTree.treeInsert(40);
		binarySearchTree.treeInsert(5);
		binarySearchTree.treeInsert(0);
		binarySearchTree.treeInsert(1);
		binarySearchTree.treeInsert(11);
		binarySearchTree.treeInsert(22);
		binarySearchTree.treeInsert(52);
		return binarySearchTree;
	}
}
