public interface Queue<T> extends Collection<T> {
	boolean add(T car);
	T peek();
	T poll();
}
