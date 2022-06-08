import java.util.Iterator;

public class LinkedList<T> implements List<T>, Queue<T> {

	private Node first;
	private Node last;
	private int size = 0;

	@Override
	public T get(int index) {
		return getNode(index).value;
	}

	@Override
	public boolean add(T t) {
		if (size == 0) {
			first = new Node(null, t, null);
			last = first;
		} else {
			Node secondLast = last;
			last = new Node(secondLast, t, null);
			secondLast.next = last;
		}
		size++;
		return true;
	}

	@Override
	public T peek() {
		return size > 0 ? get(0) : null;
	}

	@Override
	public T poll() {
		if (size > 0) {
			T t = get(0);
			removeAt(0);
			return t;
		}
		return null;
	}

	@Override
	public boolean add(T t, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {
			return add(t);
		}
		Node nodeNext = getNode(index);
		Node nodePrevious = nodeNext.previous;
		Node newNode = new Node(nodePrevious, t, nodeNext);
		nodeNext.previous = newNode;
		if (nodePrevious != null) {
			nodePrevious.next = newNode;
		} else {
			first = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(T t) {
		int index = findElement(t);
		if (index != -1) {
			return removeAt(index);
		}
		return false;
	}

	@Override
	public boolean contains(T t) {
		return findElement(t) != -1;
	}

	@Override
	public boolean removeAt(int index) {
		Node node = getNode(index);
		Node nodeNext = node.next;
		Node nodePrevious = node.previous;
		if (nodeNext != null) {
			nodeNext.previous = nodePrevious;
		} else {
			last = nodePrevious;
		}
		if (nodePrevious != null) {
			nodePrevious.next = nodeNext;
		} else {
			first = nodeNext;
		}
		size--;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {

			private Node node = first;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public T next() {
				T t = node.value;
				node = node.next;
				return t;
			}
		};
	}

	private int findElement(T t) {
		Node node = first;
		for (int i = 0; i < size; i++) {
			if (node.value.equals(t)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	private class Node {
		private Node previous;
		private final T value;
		private Node next;

		public Node(Node previous, T value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}
	}
}