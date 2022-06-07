import java.util.ArrayList;
import java.util.List;

public class Dealer {
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();

    public void acceptOfCars() {
        seller.acceptOfCars();
    }

    public Car sellOfCars() {
        return seller.sellOfCars();
    }

    public List<Car> getCars() {
        return cars;
    }

    //метод продажа машины

}
