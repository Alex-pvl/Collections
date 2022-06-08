import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTest {

	private Collection<Car> collection;

	@BeforeEach
	public void setUp() {
		collection = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			collection.add(new Car("Brand" + i, i));
		}
	}

	@Test
	public void contains() {
		assertTrue(collection.contains(new Car("Brand20", 20)));
		assertFalse(collection.contains(new Car("Brand200", 20)));
	}

	@Test
	public void testForeach() {
		int index = 0;
		for (Car car : collection) {
			index++;
		}
		assertEquals(100, index);
	}
}