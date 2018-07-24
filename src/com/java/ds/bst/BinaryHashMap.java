package com.java.ds.bst;

public class BinaryHashMap<K,V> {
	int CAPACITY = 20;
	Entry<K,V> elementData [] = new BinaryHashMap.Entry[CAPACITY];
	int size;
	
	public void put(K k, V v) {
		int index = findIndex(k);
		System.out.println("index for key "+ index);
		Entry<K, V> entry = elementData[index];
		
		if (entry == null) { //first entry at index
			elementData[index] = new Entry(k,v);
			size++;
		} else {
			addEntry(entry,k,v);
		}
	}
	
	private void addEntry(Entry<K, V> root, K k, V v) {
		Comparable<? super K> compr = (Comparable<? super K>) k;
		int compareValue = compr.compareTo(root.key);
		
		if(compareValue == 0){
			root.value = v;
			return;
		}

		if (compareValue > 0) {// right
			if (root.getRight() == null) {
				Entry<K, V> entry = new Entry(k,v);
				root.setRight(entry);
				size++;
			} else {
				addEntry(root.getRight(), k,v);
			}

		} else if (compareValue < 0) { // left
			if (root.getLeft() == null) {
				Entry<K, V> entry = new Entry(k,v);
				root.setLeft(entry);
				size++;
			} else {
				addEntry(root.getLeft(), k,v);
			}

		}
	}
	
	private int findIndex(K k){
		return k.hashCode() % CAPACITY;
	}
	
	public int getSize(){
		return size;
	}
	
	private static class Entry<K,V> {
		private K key;
		private V value;
		private Entry<K,V> left;
		private Entry<K,V> right;

		public Entry(K k,V v) {
			this.key = k;
			this.value = v;
		}

		public void setLeft(Entry<K,V> left) {
			this.left = left;
		}

		public void setRight(Entry<K,V> right) {
			this.right = right;
		}

		public Entry<K,V> getLeft() {
			return left;
		}

		public Entry<K,V> getRight() {
			return right;
		}

	}

}
