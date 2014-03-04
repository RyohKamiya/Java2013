package ex03_05;

public class OtherBenchmark extends Benchmark{
	void benchmark(int count){
		for (int i = 0; i < count; i++){
			//
		}
	}
	public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        long time = new OtherBenchmark().repeat(count);
        System.out.println(count + "methods in " + time);
}

}
