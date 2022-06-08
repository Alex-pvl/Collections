import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashSet<T> implements Set<T> {

	private final Map<T, Object> map = new HashMap<>();
	private final Object object = new Object();

	@Override
	public boolean add(T t) {
		if (map.containsKey(t)) {
			return false;
		}
		map.put(t, object);
		return true;
	}

	@Override
	public boolean remove(T t) {
		Object removed = map.remove(t);
		return removed != null;
	}

	@Override
	public boolean contains(T t) {
		return map.containsKey(t);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Iterator<T> iterator() {
		return map.keySet().iterator();
	}
}