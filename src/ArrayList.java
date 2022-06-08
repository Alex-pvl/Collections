import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements List<T> {

	private Object[] array = new Object[10];
	private int size = 0;

	@Override
	public T get(int index) {
		checkIndex(index);
		return (T) array[index];
	}

	@Override
	public boolean add(T t) {
		increaseArray();
		array[size] = t;
		size++;
		return true;
	}

	@Override
	public boolean add(T t, int index) {
		increaseArray();
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = t;
		size++;
		return true;
	}

	@Override
	public boolean remove(T t) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(t)) {
				return removeAt(i);
			}
		}
		return false;
	}

	@Override
	public boolean contains(T t) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAt(int index) {
		checkIndex(index);
		System.arraycopy(array, index + 1, array, index, size - 1 - index);
		size--;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		array = new Object[10];
		size = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			int index = 0;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public T next() {
				return (T) array[index++];
			}
		};
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void increaseArray() {
		if (size >= array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
	}
}