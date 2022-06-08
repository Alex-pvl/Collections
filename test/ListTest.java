import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

	private List<Car> carList;

	@BeforeEach
	public void setUp() {
		carList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			carList.add(new Car("Brand" + i, i));
		}
	}

	@Test
	public void whenAdded100ElementsThenSizeMustBe100() {
		assertEquals(100, carList.size());
	}

	@Test
	public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
		assertTrue(carList.removeAt(5));
		assertEquals(99, carList.size());
	}

	@Test
	public void whenElementRemovedThenSizeMustBeDecreased() {
		Car car = new Car("Toyota", 15);
		carList.add(car);
		assertEquals(101, carList.size());
		assertTrue(carList.remove(car));
		assertEquals(100, carList.size());
	}

	@Test
	public void whenNonExistentElementRemovedThenReturnFalse() {
		Car car = new Car("Toyota", 15);
		assertFalse(carList.remove(car));
		assertEquals(100, carList.size());
	}

	@Test
	public void whenListClearedThenSizeMustBe0() {
		carList.clear();
		assertEquals(0, carList.size());
	}

	@Test
	public void whenIndexOutOfBoundsThenThrownException() {
		assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100));
	}

	@Test
	public void methodGetReturnedRightValue() {
		Car car = carList.get(0);
		assertEquals("Brand0", car.getBrand());
	}

	@Test
	public void insertIntoMiddle() {
		Car car = new Car("BMW", 1);
		carList.add(car, 50);
		Car carFromList = carList.get(50);
		assertEquals("BMW", carFromList.getBrand());
	}

	@Test
	public void insertIntoFirstPosition() {
		Car car = new Car("BMW", 1);
		carList.add(car, 0);
		Car carFromList = carList.get(0);
		assertEquals("BMW", carFromList.getBrand());
	}

	@Test
	public void insertIntoLastPosition() {
		Car car = new Car("BMW", 1);
		carList.add(car, 100);
		Car carFromList = carList.get(100);
		assertEquals("BMW", carFromList.getBrand());
	}
}