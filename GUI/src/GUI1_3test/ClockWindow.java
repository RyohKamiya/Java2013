package GUI1_3test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ClockWindow extends Window{

	public ClockWindow(Frame owner) {
		super(owner);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Image imgBuffer;//buffer用のイメージ
	private Graphics gBuffer;//buffer用のGraphicsクラス

	private int width = 100;
	private int height = 100;
	public static final Color DefaultBackgroundColor = Color.blue;

	private String dispDate;
	private int fontStyle = Font.BOLD;//default のフォント
	private int fontSize = 100;//defaultのフォントサイズ
	private String fontName = "Times New Roman";
	private Font f = new Font(fontName,fontStyle,fontSize);

	private Color backgroundColor = DefaultBackgroundColor;
	private Color fontColor = Color.black;

	private FontMetrics fm;

	private int strHeight;
	private int strWidth;

	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();

	public static Dimension minimumDimension;

	public boolean isResize = false;

	private PopupMenu popMenu;

	private Color[] cr = {Color.black,Color.white,Color.blue,Color.green,Color.red};
	private String[] strCrs = {"Black","White","Blue","Green","Red"};
	public static final String[] SIZES = {"10","30","50","70","100","150","200"};
	public String[] fontNames = {"arial", "Century","Times New Roman"};

	public void createMainForm(){
		minimumDimension = this.getMinimumSize();
		this.setMainForm();
		this.setMenuForm();
		this.receiveMouseEvent(this);

	}
	public void paint(Graphics gr){
		Dimension d = getSize();
		//buffering 処理
		//Buffer用のイメージが作られていないかサイズが変わったら作り直し
		if(imgBuffer == null || imgBuffer.getWidth(this) != d.width || imgBuffer.getHeight(this) != d.height || this.backgroundColor != this.DefaultBackgroundColor){
			imgBuffer = createImage(d.width,d.height);
			gBuffer = null;
		}
		//buffer用Graphicsもなければ作る
		if(gBuffer == null)
			gBuffer = imgBuffer.getGraphics();

		gBuffer.clearRect(0, 0, d.width, d.height);
		gBuffer.setFont(f);
		gBuffer.setColor(fontColor);

		fm = gBuffer.getFontMetrics();
	    strWidth = fm.stringWidth(dispDate);
	    strHeight = fm.getHeight();
	    //Fontが設定されたときのみFontサイズに合わせてFrameサイズを変更する

	    if(dispDate!=null){
	    	try{
	    		this.width = strWidth + minimumDimension.width;
	    	}
	    	catch(Exception e){
	    		System.out.println(minimumDimension.width);
	    	}
	    	height = fm.getHeight();
	    	this.setSize(new Dimension(width, height));
	    }
	    gBuffer.drawString(dispDate, (getSize().width-strWidth)/2,(height - fm.getHeight())/2 + fm.getAscent());

	    gr.drawImage(imgBuffer,0,0,this);

		isResize = false;

	}
	public void setSetting(String fname,int fsize, Color fcolor, Color bcolor ){
		this.fontName = fname;
		this.fontSize = fsize;
		this.backgroundColor = bcolor;
		this.setBackground(backgroundColor);
		f = new Font(fontName,fontStyle,fontSize);

		this.fontColor = fcolor;


	}
	//Formのパラメータを設定
	private void setMainForm(){
		this.setSize(new Dimension(width,height));
		this.setLocation(ENV.getMaximumWindowBounds().width/2,ENV.getMaximumWindowBounds().height/2);
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setVisible(true);
	}

	public void setDispDate(String date){
		dispDate = date;
	}

	//メニューバー設定用
	private void setMenuForm(){

		 popMenu = new PopupMenu();
	     Menu menuSetting = new Menu("メニュー");
	     Menu fontMenu = new Menu("フォント");
	     Menu colorMenu = new Menu("フォントカラー");
	     Menu sizeMenu = new Menu("サイズ");
	     Menu backColor = new Menu("背景色");


	     MenuItem quit = new MenuItem("終了");

	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

	     for(int i = 0;i < cr.length;i++){
	    	 colorMenu.add(new MenuItem(strCrs[i]));
	    	 backColor.add(new MenuItem(strCrs[i]));

	     }

	     for(int i = 0;i < this.SIZES.length;i++)
	    	 sizeMenu.add(new MenuItem(SIZES[i]));


	     for(int i = 0;i < fontNames.length;i++){
	    	 fontMenu.add(new MenuItem(fontNames[i]));
	     }

	     menuSetting.add(fontMenu);
	     menuSetting.add(colorMenu);
	     menuSetting.add(sizeMenu);
	     menuSetting.add(backColor);
	     menuSetting.add(quit);

	     popMenu.add(menuSetting);
	     this.add(popMenu);

	     recievePressQuitButtonEvent(quit);
	     recivePressFontButtonEvent(fontMenu,this);
	     recivePressFontColorButtonEvent(colorMenu,this);
	     recivePressBackColorButtonEvent(backColor,this);
	     recivePressFontSizeButtonEvent(sizeMenu,this);

	}
	//Quitボタンが押された時の挙動を定義
	private void recievePressQuitButtonEvent(MenuItem quit){
		class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				//Quitボタンを押したときの動作を記述
				System.exit(0);
			}
		}
		quit.addActionListener(new MyActionListener());
	}
	//Fontが選択された時の挙動を定義
	private void recivePressFontButtonEvent(Menu fontMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				w.setSetting(e.getActionCommand(), w.fontSize, w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < fontNames.length;k++)
			fontMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Colorが選択された時の挙動を定義
	private void recivePressFontColorButtonEvent(Menu colorMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				int index = 0;
				for(int i = 0;i<strCrs.length;i++)
					if(strCrs[i].equals(e.getActionCommand())){
						index = i;
						break;
					}
				w.setSetting(w.fontName, w.fontSize, cr[index], w.backgroundColor);
			}
		}
		for(int k = 0;k < strCrs.length;k++)
			colorMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Colorが選択された時の挙動を定義
	private void recivePressBackColorButtonEvent(Menu backColor,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				int index = 0;
				for(int i = 0;i<strCrs.length;i++)
					if(strCrs[i].equals(e.getActionCommand())){
						index = i;
						break;
					}
				w.setSetting(w.fontName, w.fontSize, w.fontColor, cr[index]);
			}
		}
		for(int k = 0;k < strCrs.length;k++)
			backColor.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Sizeが選択された時の挙動を定義
	private void recivePressFontSizeButtonEvent(Menu sizeMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				w.setSetting(w.fontName, Integer.valueOf(e.getActionCommand()), w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < SIZES.length;k++)
			sizeMenu.getItem(k).addActionListener(new MyActionListener(w));
	}

	//double buffering のためのオーバーライド
	public void update(Graphics g){
			paint(g);
		}
	//マウスをクリック、ドラッグしたときの挙動を定義
	public void receiveMouseEvent(Window w){
		class MouseDrag implements MouseMotionListener,MouseListener{

			private Point draggedPoint;
			private Point pressedPoint;
			private Point startPos;
			private Window w;
			public MouseDrag(Window w){
				this.w = w;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自動生成されたメソッド・スタブ
					//System.out.println("dragged");

				draggedPoint = MouseInfo.getPointerInfo().getLocation();
				//System.out.println(draggedPoint.x - xdiff);
				 w.setLocation(draggedPoint.x , draggedPoint.y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				if(e.getButton() == MouseEvent.BUTTON3){
					// 右クリックされた時の処理;
					popMenu.show(w, e.getPoint().x + 10, e.getPoint().y);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			Point getScreenLocation(MouseEvent e) {
			    Point p1 = e.getPoint();
			    Point p2 = w.getLocationOnScreen();
			    return new Point(p1.x+p2.x, p1.y+p2.y);
			  }
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				//pressedPoint  = getScreenLocation(e);
			    //startPos = w.getLocation();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				 //Point cursor = e.getLocationOnScreen();
				   // int xdiff = cursor.x - pressedPoint.x;
				    //int ydiff = cursor.y - pressedPoint.y;
				    //w.setLocation(startPos.x + xdiff, startPos.y + ydiff);
			}
		}
		this.addMouseMotionListener(new MouseDrag(w));
		this.addMouseListener(new MouseDrag(w));
	}
}
