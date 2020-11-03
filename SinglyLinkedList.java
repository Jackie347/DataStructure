package com.jackie;

public class SinglyLinkedList<E> {

	/* A node structure for the building of SinglyLinkedList */
	private static class Node<E> {

		/* Store the data value */
		private E data;
		/* Link of the next node in the list */
		private Node<E> next;

		/**
		 * Construct a node with the given data value and link
		 * 
		 * @param data - The data value
		 * @param next - The link
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Construct a node with only the given data value
		 * 
		 * @param data - The data value
		 */
		public Node(E data) {
			this(data, null);
		}

		/**
		 * Construct a head node
		 * 
		 * @param next - The very first node of list
		 */
		public Node(Node<E> next) {
			this(null, next);
		}
	}

	/* The head of the list */
	private Node<E> head = null;
	/* The size of the list */
	private int size = 0;

	// Helper Methods

	/**
	 * Find the node at a specified index
	 * 
	 * @param index - The index of the wanted node
	 * @returns The node at index or null if it does not exist
	 */
	private Node<E> getNode(int index) {
		Node<E> p = head;
		for (int i = -1; i < index && p != null; i++) {
			p = p.next;
		}
		return p;
	}

	// Public Methods

	/**
	 * Get the size of the list
	 * 
	 * @return The number of nodes in the list
	 */
	int size() {
		return size;
	}

	/**
	 * Get the data value at index
	 * 
	 * @param index - The index of wanted node
	 * @returns The data of node at index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	/**
	 * Set the data value at index
	 * 
	 * @param index - The index of the node to change
	 * @param value - The new value
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void set(int index, E value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		node.data = value;
	}

	/**
	 * Insert a node at the specified position in the list.
	 * 
	 * @param index - Index at which the specified item is to be inserted
	 * @param value - The value of node to be inserted
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void insert(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> newNode = new Node<E>(value);
		if (index == 0) {
			head = new Node<E>(newNode);
			size++;
		} else {
			Node<E> node = getNode(index - 1);
			newNode.next = node.next;
			node.next = newNode;
			size++;
		}
	}

	/**
	 * Append the specified node to the end of the list
	 * 
	 * @param value - The value of node to be appended
	 */
	public void append(E value) {
		insert(size, value);
	}

	/**
	 * Remove the node at the specified position in the list.
	 * 
	 * @param index - The index of the node to be removed
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			Node<E> removedNode = getNode(index);
			head.next = removedNode.next;
			size--;
		} else {
			Node<E> node = getNode(index - 1);
			Node<E> removedNode = getNode(index);
			node.next = removedNode.next;
			size--;
		}
	}

	/**
	 * Obtain a string representation of the list to help printing
	 * 
	 * @return A String representation of the list
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = head;
		if (p != null) {
			while (p.next != null) {
				p = p.next;
				sb.append(p.data.toString());
				if (p.next != null) {
					sb.append(" ==> ");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

}