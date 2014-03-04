package ex03_05;

abstract class Benchmark {
    abstract void benchmark(int count);

    public final long repeat(int count) {
            long start = System.nanoTime();
            for (int i = 0; i < count; i++)
                    benchmark(count);
            return (System.nanoTime() - start);
    }
}

