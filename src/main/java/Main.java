public class Main {
    public static void main (String[] args) {
        Dealer dealer = new Dealer();
        Thread thread1 = new Thread(null, dealer::sellOfCars, "Покупатель 1");
        Thread thread2 = new Thread(null, dealer::sellOfCars, "Покупатель 2");
        Thread thread3 = new Thread(null, dealer::sellOfCars, "Покупатель 3");

        Thread thread4 = new Thread(null, dealer::acceptOfCars);
        Thread thread5 = new Thread(null, dealer::acceptOfCars);
        Thread thread6 = new Thread(null, dealer::acceptOfCars);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();


    }
}
