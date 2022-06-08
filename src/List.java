public interface List<T> extends Collection<T> {
	T get(int index);

	boolean add(T t);

	boolean add(T t, int index);

	boolean remove(T t);

	boolean removeAt(int index);

	int size();

	void clear();
}