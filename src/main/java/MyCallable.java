import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int count = 0;

    @Override
    public String call() {
        try {
            while (random() != 3) {
                Thread.sleep(2500);
                System.out.println(Thread.currentThread().getName() + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.printf("%s. завершен\n", Thread.currentThread().getName());
        }
        return Thread.currentThread().getName() + " - " + count;
    }

    private int random() {
        return (int) (Math.random() * 7);
    }
}
