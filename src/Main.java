import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<CarOwner, Car> map = new HashMap<>();
		CarOwner key = new CarOwner(1, "Name", "LastName");
		map.put(key, new Car("Brand1", 1));
		key.setId(8);
		for (CarOwner carOwner : map.keySet()) {
			System.out.println(carOwner.getId());
		}
		Car car = map.get(key);
		System.out.println(car.getBrand());
	}
}