package GUI1_2;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import GUI1_1.Finish;

public class GUIFrame extends Frame implements Runnable{
	private static int h;           //hour
	private static int m;           //minute
	private static int s;           //second;
	private int x;
	Image    imgBuffer;                 /* バッファ用のイメージ */
    Graphics gBuffer;                   /* バッファ用のGraphicsクラス */

	public Calendar now = Calendar.getInstance();
	public Thread th = new Thread(this);

	public GUIFrame(){


		//フレーム作成
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		MenuBar menubar = new MenuBar();
		Menu menu1 = menubar.add(new Menu("フォント"));
		Menu menu2 = menubar.add(new Menu("フォントサイズ"));
		Menu menu3 = menubar.add(new Menu("文字の色"));
		Menu menu4 = menubar.add(new Menu("背景色"));

		menu2.add(new MenuItem("10"));
		menu2.add(new MenuItem("15"));
		menu2.add(new MenuItem("20"));
		menu2.add(new MenuItem("25"));

		this.setMenuBar(menubar);

		this.setSize(200 ,200);
		this.setVisible(true);
		this.setSize(400 ,400);
		th.start();
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


    public void update(Graphics g){
    	paint(g);
    }

    public void paint(Graphics g)
    {
    	/* キャンバスのサイズを取得する */
        Dimension d = getSize();

        /* バッファ用のイメージが作られていないかサイズが変わったら作り直し */
        /* 毎回作るようにしても良いが、処理に時間がかかる処理なので、必要な時にしか作らないようにする */
        if( imgBuffer == null || imgBuffer.getWidth(this) != d.width || imgBuffer.getHeight(this) != d.height ){
            imgBuffer = createImage(d.width, d.height);
            gBuffer = null;
        }

        /* バッファ用Graphicsがなければ作る */
        if( gBuffer == null ){
            gBuffer = imgBuffer.getGraphics();
        }

        /* バッファをクリアする */
        /* バッファなのでクリアしてもちらつかない */
        gBuffer.clearRect(0, 0, d.width, d.height);


    	g.drawString(h + ":" + m + ":" + s,100,100);

    }
}
