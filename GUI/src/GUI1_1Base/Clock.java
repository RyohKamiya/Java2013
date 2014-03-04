package GUI1_1Base;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Clock extends Frame implements Runnable{
    
	private static int h;           //hour
	private static int m;           //minute
	private static int s;           //second
	private boolean sw = false;
	
    public static Clock clock = new Clock();
    public static Thread th = new Thread(clock);
    public Calendar now = Calendar.getInstance(); 
    
	public static void main(String [] args) {
		//フレーム作成
		clock.setSize(200, 100);
		clock.setVisible(false);
        th.start();   //スレッドスタート
        clock.addWindowListener(new Finish());
        
    }
    
    public void run(){
        while(true){
              h = now.getInstance().get(now.HOUR_OF_DAY); //時を代入
              m = now.getInstance().get(now.MINUTE);      //分を代入
              s= now.getInstance().get(now.SECOND);       //秒を代入
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