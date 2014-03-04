package GUI1_3test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockControl {
	private ClockWindow mClockWindow;
	private  ClockRun mClockRun;
	private Thread mThread;

	public class ClockRun implements Runnable{
		private boolean _halt = false;
		public void halt(){
			_halt = true;
			}

		public void run(){
			mClockWindow.setDispDate(getTime());
			mClockWindow.createMainForm();

				while(!_halt){
				mClockWindow.setDispDate(getTime());
				//System.out.println("repaint");
				mClockWindow.repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ClockControl(){
		mClockWindow = new ClockWindow(null);
	}

	public void startClock(){
		mClockRun = new ClockRun();
		mThread = new Thread(mClockRun);
		mThread.start();
	}
	public void closeClock(){
		mClockRun.halt();
		mClockWindow.dispose();
	}

	public String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
		return sdf.format(new Date().getTime());
	}
}
