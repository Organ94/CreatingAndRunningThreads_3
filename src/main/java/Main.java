public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("Главный поток");

        System.out.println("Создаю потоки...");
        MyThread myThread1 = new MyThread(mainGroup, "Поток 1");
        MyThread myThread2 = new MyThread(mainGroup, "Поток 2");
        MyThread myThread3 = new MyThread(mainGroup, "Поток 3");
        MyThread myThread4 = new MyThread(mainGroup, "Поток 4");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        Thread.sleep(10000);
        mainGroup.interrupt();
    }
}
