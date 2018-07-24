package com.java.ds.bst;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {

	Node<T> root;
	Comparator<T> compr;

	public BinarySearchTree() {
	}

	public BinarySearchTree(Comparator<T> compr) {
		this.compr = compr;
	}

	public void add(T t) {

		if (root == null) {
			root = new Node<T>(t);
		} else {
			add(root, t);
		}
	}

	private void add(Node<T> root, T t) {
		int compare;
		if (compr != null) {
			compare = compr.compare(root.value, t);
		} else {
			compare = t.compareTo(root.value);
		}

		if (compare > 0) {// right
			if (root.getRight() == null) {
				Node<T> node = new Node<T>(t);
				root.setRight(node);
			} else {
				add(root.getRight(), t);
			}

		} else if (compare < 0) { // left
			if (root.getLeft() == null) {
				Node<T> node = new Node<T>(t);
				root.setLeft(node);
			} else {
				add(root.getLeft(), t);
			}

		}
	}
	
	public void iterateAsc(){
		travelTreeAsc(root);
	}

	private void travelTreeAsc(Node<T> root) {
		if (root != null) {
			travelTreeAsc(root.getLeft());
			System.out.print(root.getValue() + "-");
			travelTreeAsc(root.getRight());
		}
	}

	private static class Node<T extends Comparable<T>> {
		private T value;
		private Node<T> left;
		private Node<T> right;

		public Node(T t) {
			this.value = t;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public T getValue() {
			return value;
		}

		public Node<T> getLeft() {
			return left;
		}

		public Node<T> getRight() {
			return right;
		}

	}

}
