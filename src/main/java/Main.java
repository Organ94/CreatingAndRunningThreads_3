import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService trheadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> callables = createCallables(4);

        forInvokeAll(trheadPool, callables);
//        forInvokeAny(trheadPool, callables);
    }

    private static void forInvokeAny(ExecutorService trheadPool, List<Callable<String>> callables)
            throws ExecutionException, InterruptedException {
        String firstSuccessfullyTask = trheadPool.invokeAny(callables);

        trheadPool.shutdown();

        System.out.println("Результат самой успешной задачи: " + firstSuccessfullyTask);
    }

    private static void forInvokeAll(ExecutorService trheadPool, List<Callable<String>> callables)
            throws InterruptedException, ExecutionException {
        List<Future<String>> futures = trheadPool.invokeAll(callables);

        trheadPool.shutdown();

        System.out.println("Результат всех задач:");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }

    private static List<Callable<String>> createCallables(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new MyCallable())
                .collect(Collectors.toList());
    }
}
