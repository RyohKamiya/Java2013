package GUI1_2test;

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

import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends Frame implements ActionListener {

        /**
         * @param args
         */

        final static int C00 = 1000;

        DrawPanel panel = new DrawPanel();
        PropertyDialog propertyDlog = new PropertyDialog(this);
        MenuItem menuProperty, menuExit;
        Transfer transfer = new Transfer();


        public static void main(String[] args) {
                DigitalClock dc = new DigitalClock();
                dc.setVisible(true);
        }

        //コンストラクタ
        public DigitalClock(){

//                setPreferredSize(new Dimension(200, 120));
                setResizable(false);


                MenuBar menuBar = new MenuBar();
                setMenuBar(menuBar);

                Menu menuFile = new Menu("Menu");
                menuFile.addActionListener(this);
                menuBar.add(menuFile);

                menuProperty = new MenuItem("Property");
                menuProperty.addActionListener(this);
                menuFile.add(menuProperty);

                /*
                //[----]
                menuFile.addSeparator();
                //[EXIT]
                menuExit = new MenuItem("Exit");
                menuExit.addActionListener(this);
                menuFile.add(menuExit);
	*/
                panel.setPreferredSize(new Dimension(1000, 400));
                add(panel);
                panel.setFont(new Font("Dialog", Font.BOLD, 250));
                new Timer(C00, panel).start();

                pack();

                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                        }
                });
        }

        public void actionPerformed(ActionEvent e) {
                // TODO 自動生成されたメソッド・スタブ
                Object obj = e.getSource();

                if(obj == menuProperty){
                        propertyDlog.setVisible(true);

                        transfer = propertyDlog.transfer;
                        System.out.println(transfer.getWidth() + "  " + transfer.getHeight());
                        panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
                        panel.setFont(transfer.getFont());
                        panel.setCharColor(transfer.getCharColor());
                        panel.setBackground(transfer.getBgColor());
                        panel.repaint();
                        pack();
                }else if(obj == menuExit){
                        System.exit(0);
                }

        }
}
