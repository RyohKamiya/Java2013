package GUI1_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class KamiyaClock extends Frame implements ActionListener {

	//記憶用パラメータ
	Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	Transfer transfer = new Transfer();
	DrawPanel panel = new DrawPanel();
	Property propertyDlog;
	MenuItem menuProperty, menuExit;

	//コンストラクタ
	public KamiyaClock(){
		//記憶する情報
		int oldX = Integer.parseInt(prefs.get("X", "0"));
		int oldY = Integer.parseInt(prefs.get("Y", "0"));
		String oldFontName = prefs.get("newFontName", "arial");
		int oldFontSize = Integer.parseInt(prefs.get("newFontSize", "50"));
		String oldCharColor = prefs.get("newCharColor", "Black");
		System.out.println(oldCharColor);
		String oldBgColor = prefs.get("newBgColor", "White");

		transfer.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		transfer.setFontSize(oldFontSize);
		transfer.setCharColor(transfer.toColor(oldCharColor));
		transfer.setBgColor(transfer.toColor(oldBgColor));
		transfer.setWidthAndHeight(oldFontSize);

		propertyDlog = new Property(this, transfer);

		this.setLocation(oldX, oldY);

		setResizable(false);


		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		Menu menuFile = new Menu("メニュー");
		menuFile.addActionListener(this);
		menuBar.add(menuFile);

		menuProperty = new MenuItem("プロパティ");
		menuProperty.addActionListener(this);
		menuFile.add(menuProperty);

		panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
		add(panel);
		panel.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		panel.setCharColor(toColor(oldCharColor));
		panel.setBackground(toColor(oldBgColor));
		new Timer(1000, panel).start();

		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				prefs.put("X", String.valueOf(getX()));
				prefs.put("Y", String.valueOf(getY()));
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj == menuProperty){
			propertyDlog.setVisible(true);

			transfer = propertyDlog.transfer;
			prefs.put("newFontName", transfer.getFont().getName());
			prefs.put("newFontSize", String.valueOf(transfer.getFontSize()));
			prefs.put("newCharColor", transfer.colorToStr(transfer.getCharColor()));
			prefs.put("newBgColor", transfer.colorToStr(transfer.getBgColor()));

			panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
			panel.setFont(transfer.getFont());
			panel.setCharColor(transfer.getCharColor());
			panel.setBackground(transfer.getBgColor());
			panel.repaint();
			pack();
		}else if(obj == menuExit){
			prefs.put("X", String.valueOf(getX()));
			prefs.put("Y", String.valueOf(getY()));
			System.exit(0);
		}
	}

	public Color toColor(String str) {
		if(str.equals("Black")) {
			return Color.black;
		} else if(str.equals("White")) {
			return Color.white;
		} else if(str.equals("Red")) {
			return Color.red;
		} else if(str.equals("Green")) {
			return Color.green;
		} else if(str.equals("Blue")) {
			return Color.blue;
		} else {
			return null;
		}
	}
}