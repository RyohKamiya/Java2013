package GUI1_1;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Clock extends Frame implements Runnable{
    
	private static int h;           //hour
	private static int m;           //minute
	private static int s;           //second
	private boolean sw = false;
	
    
    public Calendar now = Calendar.getInstance(); 
    public Thread th = new Thread(this);
	public Clock(){
		//フレーム作成
		
		this.setSize(100, 100);
		this.setVisible(true);
        th.start();   //スレッドスタート
        this.addWindowListener(new Finish());
	}
    public void run(){
        while(true){
              h = now.getInstance().get(now.HOUR_OF_DAY);	//input hour
              m = now.getInstance().get(now.MINUTE);		//input minute
              s = now.getInstance().get(now.SECOND);		//input second
              repaint();

              try{
                  th.sleep(1000);  //スリープ１秒
              }catch(InterruptedException e){
              }               
        }
    }
    public void paint(Graphics g)
    {
        g.drawString(h + ":" + m + ":" + s,50,59);
    }
}