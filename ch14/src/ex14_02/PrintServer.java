package ex14_02;

import java.awt.PrintJob;

public class PrintServer implements Runnable{

	private final PrintQueue requests = new PrintQueue();
	private final String  name = "threadName";

	public PrintServer() {
        new Thread(this,name).start();;
    }

    public void run() {
        if(Thread.currentThread().getName().equals(name)) {
            for(;;){
            	System.out.println("OK");
            	realPrint(requests.remove());
            }
        }
        else {
            return;
        }
    }


    public void print(PrintJob job) {
        requests.add(job);
    }

    private void realPrint(ex14_02.PrintJob printJob) {

    }
}
