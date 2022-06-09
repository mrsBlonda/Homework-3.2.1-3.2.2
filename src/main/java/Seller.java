import java.beans.IntrospectionException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {
    Lock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    Dealer dealer;

    public Seller(Dealer dealer) {

        this.dealer = dealer;
    }

    public Car sellOfCars() {
        try {
            reentrantLock.lock();

            System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
            if (dealer.getCars().size() == 0) {
                System.out.println("Автомобилей в наличии нет");
                condition.await();
            }
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return dealer.getCars().remove(0);
    }

    public void acceptOfCars() {
        try {
            reentrantLock.lock();
            Thread.sleep(2000);
            System.out.println("Производитель Toyota выпустил 1 авто");
            dealer.getCars().add(new Car());
            condition.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }
}
