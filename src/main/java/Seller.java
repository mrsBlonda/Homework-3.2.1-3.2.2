import java.beans.IntrospectionException;
import java.util.List;

public class Seller {

    Dealer dealer;

    public Seller(Dealer dealer) {

        this.dealer = dealer;
    }

    public synchronized Car sellOfCars() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
            if (dealer.getCars().size() == 0) {
                System.out.println("Автомобилей в наличии нет");
                wait();
            }
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return dealer.getCars().remove(0);
    }

    public synchronized void acceptOfCars() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Производитель Toyota выпустил 1 авто");
        dealer.getCars().add(new Car());
        notify();

    }
}
